
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

    <el-table  border style="width: 100%"  :header-cell-style="{ background: '#f5f5f5' }">
        <el-table-column type="selection" width="55" />
        <el-table-column header-align="center" label="用户名"  />
        <el-table-column header-align="center" label="姓名"  />
        <el-table-column header-align="center" label="性别"  />
        <el-table-column header-align="center" label="电话"  />
        <el-table-column header-align="center" label="头像"  />

        <el-table-column header-align="center" label="操作" >
            <template slot-scope="scope">
                <el-button type="primary" size="mini" >编辑</el-button>
                <el-button type="danger" size="mini" >删除</el-button>
            </template>
        </el-table-column>
    </el-table>
    <el-pagination background layout="prev, pager, next" :total="1000" style="float:right;margin: 10px 20px 20px 0px;"/>
  </el-form>
</template>
