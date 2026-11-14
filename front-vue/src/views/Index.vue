<template>
  <div class="common-layout">
    <el-container>
      <el-header>
        <Header></Header>
      </el-header>
      <el-container>
        <el-aside class="wcy-sidebar--dark">
          <LeftMenu></LeftMenu>
        </el-aside>
        <el-container>
          <el-main class="wcy-content">
            <el-card class="welcome-card">
              <router-view></router-view>
            </el-card>
          </el-main>
          <el-footer class="layout-footer">
            <Footer></Footer>
          </el-footer>
        </el-container>
      </el-container>
    </el-container>
  </div>
</template>
<script setup lang="ts">
    import Header from "@/components/Header.vue";
    import LeftMenu from "@/components/LeftMenu.vue";
    import Footer from "@/components/Footer.vue";
</script>

<style lang="less">
    @import "../styles/style.less";
   /* 让最外层撑满整个视口，flex 才能把高度分配下去 */
.common-layout {
  height: 100vh;
  display: flex;
  flex-direction: column;
}

.el-header {
  --header--menu-height: 90px;
  height: var(--header--menu-height);
  padding: 0;
}

/* el-aside 宽度与侧栏变量保持一致，避免露出窄条 */
.el-aside {
  width: @wcy--sidebar-width;/* 去掉 el-aside 自带的滚动条 */
  overflow: hidden;
}
.wcy-sidebar__inner {
  overflow: hidden;   // 若希望完全可见可改 visible，但 hidden 更安全，防止溢出撑宽
}
/* el-main 占满剩余空间并独立滚动 */
.el-main {
  flex: 1;
  display: flex;
  flex-direction: column;
  overflow-y: auto;
  background: #f5f5f5;
}

.welcome-card {
  flex: 1;
  min-height: 0; /* 让 el-card 的高度可以被 flex 收缩 */
  display: flex;
  flex-direction: column;
  overflow: hidden; /* 让 el-card 内部的内容可以独立滚动 */
}
.welcome-card .el-card__body { 
    flex: 1;
    min-height: 0; /* 让 el-card__body 的高度可以被 flex 收缩 */
    overflow: auto;
    display: flex;
    flex-direction: column;
}
.el-footer {
  height: 30px;
  padding: 7px 0;
  display: flex;
  justify-content: center;
  background: #f5f5f5;
}
</style>