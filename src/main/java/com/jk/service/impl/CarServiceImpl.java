package com.jk.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jk.dao.CarDao;
import com.jk.dao.EmpDao;
import com.jk.pojo.EmpBean;
import com.jk.pojo.TreeBean;
import com.jk.service.CarService;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @program: es-mysql
 * @description:
 * @author: 刘洋朋
 * @create: 2021-01-05 19:22
 */
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao carDao;

    @Autowired
    private EmpDao empDao;

    @Autowired
    private ElasticsearchTemplate esTemplate;

    @Override
    public List<TreeBean> findTree() {
        int pid=0;
        List<TreeBean> list = findNodes(pid);
        return list;
    }

    @Override
    public HashMap<String, Object> efindTable(Integer page, Integer rows, EmpBean empBean) {
        HashMap<String, Object> map = new HashMap<>();
        Client client = esTemplate.getClient();
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch("emp")//设置查询索引库 数据库
                .setTypes("2006a");////设置查询类型 表
        BoolQueryBuilder bool = new BoolQueryBuilder();
        if (!StringUtils.isEmpty(empBean.getYewu())){
            bool.should(QueryBuilders.matchQuery("name",empBean.getYewu()));
            bool.should(QueryBuilders.matchQuery("zname",empBean.getYewu()));
        }
        searchRequestBuilder.setQuery(bool);

        searchRequestBuilder.addSort("time", SortOrder.DESC);


        int start=(page-1)*rows;
        searchRequestBuilder.setFrom(start);
        searchRequestBuilder.setSize(rows);


        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("name");
        highlightBuilder.field("zname");
        highlightBuilder.preTags("<font color=\"red\">");//前缀
        highlightBuilder.postTags("</font>");//后缀
        searchRequestBuilder.highlighter(highlightBuilder);


        SearchResponse searchResponse = searchRequestBuilder.get();

        SearchHits hits = searchResponse.getHits();

        long total = hits.getTotalHits();

        Iterator<SearchHit> iterator = hits.iterator();
        List<EmpBean> list = new ArrayList<>();
        while (iterator.hasNext()){
            SearchHit next = iterator.next();
            String str = next.getSourceAsString();

            EmpBean empBean1 = JSONObject.parseObject(str, EmpBean.class);

            Map<String, HighlightField> highlightFields = next.getHighlightFields();
            HighlightField name = highlightFields.get("name");
            if (name!=null){
                String name2 = name.getFragments()[0].toString();
                empBean1.setName(name2);
            }
            HighlightField zname = highlightFields.get("zname");
            if (zname!=null){
                String zname2 = zname.getFragments()[0].toString();
                empBean1.setZname(zname2);
            }
            list.add(empBean1);
        }
        map.put("rows",list);
        map.put("total",total);
        return map;
    }

    @Override
    public void addEmp(EmpBean empBean) {
        if (empBean.getId()==null) {
            carDao.addEmp(empBean);
        }else {
            carDao.updateEmp(empBean);
        }
        empDao.save(empBean);

    }

    @Override
    public Optional<EmpBean> findEmp(Integer id) {
        Optional<EmpBean> empBean = empDao.findById(id);
        return empBean;
    }

    @Override
    public void delEmp(Integer id) {
        empDao.deleteById(id);
        carDao.delEmp(id);

    }

    private List<TreeBean> findNodes(int pid) {
        List<TreeBean> list = carDao.findTreeByPid(pid);
        for (TreeBean tree : list) {
            Integer id = tree.getId();
            List<TreeBean> nodelist = findNodes(id);//递归自己调自己
            //判断是否有子节点：有子节点-->打开  false  没有子节点-->不能打开 true
            if(nodelist!=null&&nodelist.size()>0){//有子节点
                tree.setNodes(nodelist);
                tree.setSelectable(false);//有子节点-->打开  false
            }else{//没有子节点
                tree.setSelectable(true);//没有子节点-->不能打开 true
            }
        }
        return list;
    }
}
