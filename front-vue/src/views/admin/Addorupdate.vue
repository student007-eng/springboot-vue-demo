<template>
    <el-dialog
  v-model="dialogVisible"
  :title="!form.id?'新增':'编辑'"
  width="500"
>
  <el-form :rules="rules" :model="form" ref="formRef" label-width="100px">
    <el-form-item label="用户名" prop="username" :readonly="readonly" :rules="rules.username">
      <el-input v-model="form.username" placeholder="用户名" />
    </el-form-item>
    <el-form-item label="密码" prop="userpwd" :rules="rules.userpwd">
      <el-input v-model="form.userpwd" type="password" placeholder="密码" />
    </el-form-item>
    <el-form-item label="姓名" prop="name" :rules="rules.name">
      <el-input v-model="form.name" placeholder="姓名" />
    </el-form-item>
    <el-form-item label="性别" prop="sex" :rules="rules.sex">
      <div style="flex: 1;">
        <el-select v-model="form.sex" placeholder="请选择" style="width: 100%">
          <el-option label="男" value="男" />
          <el-option label="女" value="女" />
        </el-select>
      </div>
    </el-form-item>
    <el-form-item label="电话" prop="tel" :rules="rules.tel">
      <el-input v-model="form.tel" placeholder="电话" />
    </el-form-item>
    <el-form-item label="头像" prop="headurl" :rules="rules.headurl">
      <el-input v-model="form.headurl" placeholder="头像" />
    </el-form-item>
  </el-form>
  <template #footer>
    <div class="dialog-footer">
      <el-button @click="dialogVisible = false">取消</el-button>
      <el-button type="primary" @click="onSubmit()" :loading="btnLoading">
        确定
      </el-button>
    </div>
  </template>
</el-dialog>




</template>
<script setup lang="ts">
import { reactive, ref } from 'vue';
import { adminApi } from '@/api/admin-api';
import { ElMessage } from 'element-plus';
defineExpose({showDialog})
// 控制弹窗显示隐藏
const dialogVisible = ref(false);
const btnLoading = ref(false);
const emit=defineEmits(['refresh']);
const readonly=ref(false);
function showDialog(row) {
    if(row){
        readonly.value=true;
        Object.assign(form,row);
    }else{
        readonly.value=false;
        Object.assign(form,formDefault);
    }
    
    dialogVisible.value = true;
}
//表单组件
const formRef=ref();
//表单初始值
const formDefault = {
  id: '',
  username: '',
  userpwd: '',
  name: '',
  sex: '',
  tel: '',
  headurl: ''
}
let form=reactive({...formDefault})

const rules=reactive({ 
    username: [
      { required: true, message: '请输入用户名', trigger: 'blur' },
      { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
    ],
    userpwd: [
      { required: true, message: '请输入密码', trigger: 'blur' },
      { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
    ],
    name: [
      { required: true, message: '请输入姓名', trigger: 'blur' },
      { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
    ],
    tel: [
      { required: true, message: '请输入电话', trigger: 'blur' },
      { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
    ],
    sex: [
      { required: true, message: '请选择性别', trigger: 'blur' }
    ],
    headurl: [
      { required: true, message: '请设置头像', trigger: 'blur' },
      { min: 3, max: 5, trigger: 'blur' }
    ]

})

function onSubmit() {
    try{
        btnLoading.value=true;
        formRef.value.validate().then(async () => {
            if(form.id){
                await adminApi.update(form);
            }else{ 
                await adminApi.add(form);
            }
            ElMessage.success("${form.id ? '修改' : '添加'}成功");
            btnLoading.value=false;
            dialogVisible.value=false;
            emit('refresh');
        })
    }catch(err){

    }finally{
        btnLoading.value=false;
    }
  console.log("form.username:", form.username);
}
</script>