Vue
.createApp({
	data(){
		return{
            test:"hello test",
            list:[ ],
            categoryList:[ ],
            detailList:[ ],
            stuff:{
                title:"제목",
                place:"장소",
                numPeople:"numPeople",
                price:"가격",
                url:"url",
                content:"content",
                deadline:"9999-99-99"
            },
            category:{
                id:0,
                name:"카테고리제목"
            }

        };
    },
    methods:{
        testHandler(e){
            console.log("testClick");
        },
       async load(){
            await fetch("/stuffs")
            .then(response=>{
                return response.json();
            })
            .then(list=>{
                this.list = list;
                console.log(this.list);
            })
            .then(error => {
                console.log('에러');
            })
            ;
        },
        async getCategoryList(){
            await fetch("/stuffs/category")
            .then(response=>{
                return response.json();
            })
            .then(categoryList=>{
                this.categoryList = categoryList;
                console.log(this.categoryList);
            })
            .then(error => {
                console.log('에러');
            })
            ;
        },
        categoryClickHandler(e){

        },
        get(e){
              fetch("{id}")
                .then(response => {
                   return response.json();
                })
                .then(detailList => {
                    this.detailList = detailList;
                    console.log(this.detailList);
                })
                .catch(error => 
                    console.log('error', error));
        }


    },
	beforeCreate(){console.log("beforeCreate")},
	created(){console.log("created")},
	beforeMount(){console.log("beforeMount")},
    mounted(){
        console.log("mounted");
        this.load();
        this.getCategoryList();
    },
	beforeUpdate(){console.log("beforeUpdate")},
	updated(){console.log("updated")},
	beforeUnmount(){console.log("beforeUnmount")},
	unmounted(){console.log("unmounted")}
})
.mount("#list-vue");



// window.addEventListener("load", function(){

//     var heartList = document.getElementsByClassName('icon-heart');


//     function heartClick(e) {
//         e.stopPropagation();
//         e.target.classList.toggle('icon-empty-heart');
//         e.target.classList.toggle('icon-full-heart');
//     }

//     for (var i = 0; i < heartList.length; i++) {
//         heartList[i].addEventListener("click", heartClick);
//     }
    
// });