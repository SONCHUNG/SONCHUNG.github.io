<script>
import Index from './components/Index.vue';
import Login from './components/Login.vue';
import Signup from './components/Signup.vue';
import List from './components/List.vue';
import Reg from './components/Reg.vue';
import Detail from './components/Detail.vue';

export default {
  components:{
      Index,
      Login,
      Signup,
      List,
      Reg,
      Detail
  },
  data(){
    return
  }

}

</script>

<template>
  <Index />
  <Login />
  <Signup />
  <List />
  <Reg />
  <Detail />
</template>

<style>
@import './assets/reset.css';
@import './assets/utils.css';
@import './assets/style.css';
@import './assets/button.css';
@import './assets/component/component.css';

</style>

