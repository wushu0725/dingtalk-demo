<template>
    <div class="cell-box" v-on:click="microAppsOpenLink(item,$event)">
        <div class="cell-image-container">
            <img class="cell-image" v-bind:src="item.icon" />
        </div>
        <div class="cell-text">{{ item.name }}11</div>
    </div>
</template>

<script>
    var lock = true;
    export default{
        name: 'singleApp',
        props: ['item'],
        data: function () {
            return {

            };
        },
        mounted: function () {

        },
        methods: {
            microAppsOpenLink: function (item,e) {
                alert(222);
            }
        }
    }
</script>

<style>
    .cell-image-container{
        width: 50px;
        height: 49px;
        position: relative;
        border-radius: 10px;
        background-color: #f8f8f8;
        overflow: hidden;
        margin: 0 auto;
    }
    .cell-image{
        width: 50px;
        height: 49px;
        border-radius: 10px;
    }
    .cell-text{
        text-align: center;
        color: #323334;
        font-size: 13px;
        margin-top: 12px;
    }
</style>
