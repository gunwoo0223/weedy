<template>
    <div>
        aaa
    </div>
</template>

<script>
import axios from 'axios'

export default {
    created(){
        axios.get('/searchList')
                .then((response) => {
                    alert("searchList Data Access success!!");
                }).catch((ex) => {
                    alert("searchList Data Access Fail!!"+ ex);
                })
    },
}
</script>

<style scoped>

</style>