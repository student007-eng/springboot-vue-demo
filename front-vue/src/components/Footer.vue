<template>
  <div class="version">
    <a target="_blank" class="copyright" href="http://www.github.com/Student007-eng">©2026-{{ currentYear }} springboot-vue脚手架</a>
    <a target="_blank" class="copyright" href="http://www.github.com/Student007-eng"> Student007-eng</a>
  </div>
</template>

<script setup>
import dayjs from 'dayjs';
const currentYear = dayjs().year();
</script>

<style lang="less" scoped>
.version,.copyright {
  font-size: 14px;
  font-size: 14px;
  color: rgba(0, 0, 0, 0.45);
  a:hover {
    color: #0a0e14;
  }
}
</style>
