<template>
  <div class="wcy-sidebar__inner">
    <el-menu :collapseTransition="false" class="wcy-sidebar__menu" background-color="#263238"
      active-text-color="#fff" text-color="#8a979e">
      <el-menu-item index="welcome" @click="$router.push({ name: 'welcome' })">
        <el-icon>
          <Document />
        </el-icon>
        <span slot="title">首页</span>
      </el-menu-item>

      <el-menu-item index="welcome" @click="$router.push({ path: '/index/welcome' })">
        <el-icon>
          <Document />
        </el-icon>
        <span slot="title">欢迎页</span>
      </el-menu-item>

      <el-sub-menu index="组织管理" :popper-class="'wcy-sidebar--dark-popper'">
        <template #title>
          <el-icon>
            <Document />
          </el-icon>
          <span slot="title">管理员信息管理</span>
        </template>
        <el-menu-item index="admin" @click="$router.push({ path: '/index/admin' })">
          <el-icon>
            <Document />
          </el-icon>
          <span slot="title">管理员信息管理</span>
        </el-menu-item>
      </el-sub-menu>
      <el-sub-menu index="组织管理2" :popper-class="'wcy-sidebar--dark-popper'">
        <template #title>
          <el-icon>
            <Document />
          </el-icon>
          <span slot="title">组织管理</span>
        </template>
        <el-menu-item index="MisDept" @click="$router.push({ name: 'MisDept' })">
          <el-icon>
            <Document />
          </el-icon>
          <span slot="title">部门管理</span>
        </el-menu-item>
        <el-menu-item index="MisDept" @click="$router.push({ name: 'MisDept' })">
          <el-icon>
            <Document />
          </el-icon>
          <span slot="title">部门管理</span>
        </el-menu-item>
        <el-menu-item index="MisDept" @click="$router.push({ name: 'MisDept' })">
          <el-icon>
            <Document />
          </el-icon>
          <span slot="title">部门管理</span>
        </el-menu-item>
       
      </el-sub-menu>
    </el-menu>
  </div>
</template>

<script lang="ts" setup>
import {
  Document,
  Menu as IconMenu,
  Location,
  Setting,
} from '@element-plus/icons-vue'
const handleOpen = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
const handleClose = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
</script>
