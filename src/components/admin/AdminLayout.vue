<script>
    import Header from './Header.vue';
    import Aside from './Aside.vue';

    export default {
        components:{
            Header,
            Aside
        },
        data(){
            return{
            }
        }
    }
</script>

<template>
    <Header/>
    <!-- --------------------------------------- -->
    <Aside/>
    <!-- --------------------------------------- -->
    <router-view></router-view>
</template>
