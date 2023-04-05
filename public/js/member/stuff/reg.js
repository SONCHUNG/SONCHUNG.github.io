/* window.addEventListener("load", function(){

    // reg1에서 reg2로 페이지 이동 
    const reg2 = document.querySelector('.reg2-form');
    const reg1 = document.querySelector('.reg1-form');
    const btnReg = document.querySelector('.btn-next');
    const backArrow = document.querySelector('.reg2-back');

    const resultElement = document.querySelector('#result');
    const btnMinus = document.querySelector('.btn-minus');
    const btnPlus = document.querySelector('.btn-plus');

    btnReg.addEventListener('click', () => {
        // console.log("다음 출력");
        reg1.classList.toggle('d-none');
        reg2.classList.toggle('d-none');
    });

    backArrow.addEventListener('click', () => {
        // console.log("뒤로가기 출력");
        reg2.classList.toggle('d-none');
        reg1.classList.toggle('d-none');
    });


    // 인원수 조절 JS 
    // 현재 화면에 표시된 값
    let number = resultElement.value;

    btnMinus.addEventListener('click', () => {
        number = parseInt(number) - 1;
        resultElement.value = number;
    });

    btnPlus.addEventListener('click', () => {
        number = parseInt(number) + 1;
        resultElement.value = number;
    });
    

    // function count(type)  {
    //     // 결과를 표시할 element
    //     const resultElement = document.getElementById('result');
    //     // 현재 화면에 표시된 값
    //     let number = resultElement.innerText;
    //     // 더하기/빼기
    //     if(type === 'plus') {
    //       number = parseInt(number) + 1;
    //     }else if(type === 'minus')  {
    //       number = parseInt(number) - 1;
    //     }
    //     // 결과 출력
    //     resultElement.innerText = number;
    //   }
});
*/


// 위에 있는 JS 이벤트 핸들러 Vue로 다 바꾸기!!** DOM과 Vue 중에서 우선 순위가 Vue.js이다. 
// ================== Vue.js ============================================

Vue
.createApp({
	
	// 테스트부터 해볼 것!
	data() {
	  return {
        test:"?",
        isActive:true,
        file:[""],
        image:'',
        result:[],
        imageURL:'',     
        categoryList:[],
        stuff:{
            title: "아메리카노",
            place: "이촌동",
            numPeople: "3",
            deadline: "",
            price: "2000",
            url: "www.naver.com",
            content: "5000",
            imageList: [
              {
                "id": 3,
                "name": "24324324",
                "stuffId": 3
              }
            ]
          }
        // [title : "아메리카노",
        // place:"이촌동",
        // numPeople:"3",
        // deadline:"2018-12-15T10:11:22",
        // price:"2000",
        // url:"www.naver.com",
        // content:"5000",
        // imageList:[{"id":3,"name":"24324324","stuffId":3}]]
	  };
	},
	
	methods:{
        dnoneHandler(){
            this.isActive=!this.isActive;
        },

        // 공구상품 글 업로드
        // stuffUploadHandler() {


        //     console.log("hihi")
        //     var myHeaders = new Headers();
        //     myHeaders.append("Content-Type", "application/json");

        //     // 여기만 바꿔주기!!**
            
        //     // this.stuff.imageList = imageUploadImage();
        //     var raw = JSON.stringify(this.stuff);


        //     var requestOptions = {
        //         method: 'POST',
        //         headers: myHeaders,
        //         body: raw,
        //         redirect: 'follow'
        //     };
            
        //     // 목록 다시 갱신!!
        //     fetch("http://localhost:8080/member/stuffs", requestOptions)
        //         .then(response => response.text())
        //         .then(result => {
        //             console.log(result);
        //             // imageUploadImage(result);
        //         })
        //         .catch(error => console.log('error', error));
        // },

        // JS를 이용한 AJAX 파일 업로드 
        // imageUploadImage(e){
            
        //     // this.file = e.target.files[0];
        //     // let file = e.target.files[0];
            
        //     this.file = e.target.files[0];
        //     console.log(this.file);
            
        //     // let url = URL.createObjectURL(this.file);
        //     // this.imageURL = url;
        //     // console.log(url);
        //     // 너무 열심히 찾아서 없애주기!!
        //     // boundary를 찾지 못한다는 소리인데 Content-Type을 지정해두게 되면 
        //     // Multipart boundary를 열심히 찾는구나~ 라고 이해하고 주석처리하니까
            
        //     var myHeaders = new Headers();
        //     myHeaders.append("Content-Type", "multipart/form-data");
            
        //     var formdata = new FormData();
        //     formdata.append("imgs", this.file);
        //     formdata.append("stuff", this.stuff);
        //     console.log(formdata);
            
        //     var requestOptions = {
        //       method: 'POST',
        //       headers: myHeaders,
        //       body: formdata,
        //       redirect: 'follow'
        //     };
            
        //     fetch("http://localhost:8080/member/stuffs/upload", requestOptions)
        //       .then(response => response.json())
        //       .then(result => {
        //         this.result = result
        //         console.log(this.result);
        //         console.log(result);
        //         //stuffUploadHandler(result)
        //         })
        //       .catch(error => console.log('error', error));
            
        // },

        upload(){
          console.log(this.stuff);
          // var myHeaders = new Headers();
          // myHeaders.append("Content-Type", "multipart/form-data");

          var formData = new FormData();
          formData.append("stuff", this.stuff);
          formData.append("imgs", this.file);
         

          var requestOptions = {
            method: 'POST',
            // headers: myHeaders,
            body: formData,
            redirect: 'follow'
          };
          
          // 카테고리 id 넣어주기!!
          fetch("http://localhost:8080/member/stuffs/upload", requestOptions)
            .then(response => response.text())
            .then(result => console.log(result))
            .catch(error => console.log('error', error));

        },

        // 썸네일 조작
        uploadImage(e){

            this.file = e.target.files;
            console.log(this.file);
            url = URL.createObjectURL(this.file[0]);
            console.log(url);
            
            this.imageURL = url;
            
        },

        loadCategory(){
          var requestOptions = {
            method: 'GET',
            redirect: 'follow'
          };
          
          fetch("http://localhost:8080/member/stuffs/categories", requestOptions)
            .then(response => response.json())
            .then(categoryList => {
              this.categoryList = categoryList
              console.log(this);
            })
            .catch(error => console.log('error', error));
        }
	},
	
	beforeCreate(){console.log("beforeCreate")},
	created(){console.log("created")},
	beforeMount(){console.log("beforeMount")},
	mounted(){
		console.log("mounted")
        
        // this.imageUploadImage();
        this.uploadImage();
        this.upload();
		    // this.stuffUploadHandler();
        this.dnoneHandler();
        this.loadCategory();
	},
	beforeUpdate(){console.log("beforeUpdate")},
	updated(){console.log("updated")},
	beforeUnmount(){console.log("beforeUnmount")},
	unmounted(){console.log("unmounted")}
	
})
.mount('#reg-main-section');

