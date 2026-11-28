
<template>
    <el-form :inline="true">
    <el-form-item label="姓名">
      <el-input v-model="queryForm.name" placeholder="姓名" />
    </el-form-item>
    <el-form-item label="电话">
      <el-input v-model="queryForm.tel" placeholder="电话" />
    </el-form-item>
    <el-form-item >
        <el-button type="primary" @click="onSearch">查询</el-button>
        <el-button type="primary" @click="add()">新增</el-button>
        <el-button type="danger"  @click="confirmDel()">批量删除</el-button>
    </el-form-item>
    

    <el-divider border-style="dashed" />

    <el-table  border :data="datalist" v-loading="listLoading" style="width: 100%"  :header-cell-style="{ background: '#f5f5f5' }" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" />
        <el-table-column header-align="center" align="center" label="用户名" prop="username" />
        <el-table-column header-align="center" align="center" label="姓名" prop="name" />
        <el-table-column header-align="center" align="center" label="性别" prop="sex" />
        <el-table-column header-align="center" align="center" label="电话" prop="tel" />
        <el-table-column header-align="center" align="center" label="头像" prop="headurl" />

        <el-table-column header-align="center" align="center" label="操作" >
            <template #default="scope">
                <el-button type="text" size="mini" @click="update(scope.row)">编辑</el-button>
                <el-button type="text" size="mini" @click="confirmDel(scope.row.id)">删除</el-button>
            </template>
        </el-table-column>
    </el-table>
    <el-pagination background layout="prev, pager, next" :total="total" @current-change="handleCurrentPageChange" style="float:right;margin: 10px 20px 20px 0px;"/>

    <addorupdate @refresh="getList" ref="operateRef"></addorupdate>
  </el-form>
</template>

<script setup lang="ts">
import { ref, reactive } from 'vue';
import { adminApi } from '@/api/admin-api';
import { onMounted } from 'vue';
import Constants from '@/utils/constants';
import Addorupdate from './Addorupdate.vue';
import { ElMessage, ElMessageBox } from 'element-plus';
//列表数据
const datalist=ref([]);
//列表加载状态
const listLoading=ref(false);
//数据总条数
const total=ref(0);
//定义引用新增或修改组件的响应式变量
const operateRef=ref();
//所有选中的记录
const multipeSelection=ref([]);
//表单的初始值
const queryFormState={
  name:'',
  tel:'',
  pagenum:1,
  pagesize:Constants.PAGE_SIZE
};
//表单查询条件对象
const queryForm=reactive({...queryFormState});
async function getList() {
    try{
      listLoading.value=true;
      console.log("准备发起请求");
      let responseModel=await adminApi.queryPageList(queryForm,queryForm.pagenum,queryForm.pagesize);
      datalist.value=responseModel.data.records;
      total.value=responseModel.data.total;
    }catch(err){
      console.error("获取列表数据失败：", err);
    }finally{
      listLoading.value=false;
    }
}
//查询按钮点击事件
function onSearch() {
  queryForm.pagenum = 1; // Reset to first page on new search
  getList();
}
//分页查询方法
function handleCurrentPageChange(val: number) {
  queryForm.pagenum = val;
  getList();
}

function add(){
  operateRef.value.showDialog();
}
function confirmDel(id){
  ElMessageBox.confirm('是否确认删除?', '提示', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning'
  }).then(() => {
    del(id);
  }).catch(() => {
    ElMessage({
      type: 'info',
      message: '已取消删除'
    })
  })
}
async function del(id){
  try{
    listLoading.value=true;
    let ids=id?[id]:multipeSelection.value.map(item=>item.id);
    if(ids.length==0){
      ElMessage.warning("请选择要删除的记录");
      return;
    }
    await adminApi.delete(ids);
    ElMessage.success("删除成功");
    getList();
  }catch(err){

  }finally{
    listLoading.value=false;
  }
  
}
function update(row) {
    operateRef.value.showDialog(row);
}

function handleSelectionChange(val) {
  multipeSelection.value = val;
}
onMounted(getList);
</script>