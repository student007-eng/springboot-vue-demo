
<template>
    <el-form :inline="true">
    <el-form-item label="姓名">
      <el-input placeholder="姓名" />
    </el-form-item>
    <el-form-item label="电话">
      <el-input placeholder="电话" />
    </el-form-item>
    <el-form-item >
        <el-button type="primary" >查询</el-button>
        <el-button type="primary" >新增</el-button>
        <el-button type="danger" >批量删除</el-button>
    </el-form-item>
    

    <el-divider border-style="dashed" />

    <el-table  border :data="datalist" v-loading="listLoading" style="width: 100%"  :header-cell-style="{ background: '#f5f5f5' }">
        <el-table-column type="selection" width="55" />
        <el-table-column header-align="center" label="用户名" prop="username" />
        <el-table-column header-align="center" label="姓名" prop="name" />
        <el-table-column header-align="center" label="性别" prop="sex" />
        <el-table-column header-align="center" label="电话" prop="tel" />
        <el-table-column header-align="center" label="头像" prop="headurl" />

        <el-table-column header-align="center" label="操作" >
            <template slot-scope="scope">
                <el-button type="primary" size="mini" >编辑</el-button>
                <el-button type="danger" size="mini" >删除</el-button>
            </template>
        </el-table-column>
    </el-table>
    <el-pagination background layout="prev, pager, next" :total="total" style="float:right;margin: 10px 20px 20px 0px;"/>
  </el-form>
</template>

<script setup lang="ts">
import { ref } from 'vue';
import { adminApi } from '@/api/admin-api';
import { onMounted } from 'vue';
//列表数据
const datalist=ref([]);
//列表加载状态
const listLoading=ref(false);
//数据总条数
const total=ref(0);

async function getList() {
    console.log("进入getList");
    console.log("adminApi对象：", adminApi);
    console.log("adminApi.queryPageList：", adminApi.queryPageList);
    try{
      listLoading.value=true;
      console.log("准备发起请求");
      let responseModel=await adminApi.queryPageList({},1,10);
      console.log("请求返回：", responseModel);
      console.log('完整返回res：', responseModel)
      console.log('res.data：', responseModel.data)
      console.log('res.data.records：', responseModel.data.records)
      datalist.value=responseModel.data.records;
      total.value=responseModel.data.total;
    }catch(err){
      console.error("获取列表数据失败：", err);
    }finally{
      listLoading.value=false;
    }
}
console.log("script执行，准备注册onMounted");
onMounted(getList);
</script>