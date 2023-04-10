<template>
  <!-- =================== reg1 ======================= -->
  <section class="reg1-form" :class="{ 'd-none': isNext }">
    <h1 class="d-none">reg1</h1>

    <section class="canvas-1 d-fl fl-dir-col">
      <!-- =================== reg1 : header ===================== -->
      <header class="d-fl">
        <div>
          <router-link to="/member/stuff/list" class="icon icon-back"
            >뒤로가기</router-link
          >
        </div>

        <div class="hd-title-box">
          <h1 class="hd-title">카테고리 설정</h1>
        </div>
      </header>

      <!-- =================== reg1 : main ===================== -->
      <main>
        <div class="reg1-main-content">
          <h1>지역 주민들과 어떤 물건을 같이 살까요?</h1>
        </div>

        <div class="category-select">
          <ul class="select-box-list">
            <li>
              <button class="select-box categ-eff" name="merchandise">
                일반상품
              </button>
            </li>
            <li>
              <button class="select-box categ-eff" name="supermarket">
                대형마트 대량 물품
              </button>
            </li>
            <li>
              <button class="select-box categ-eff" name="delivery_food">
                딜리버리 푸드
              </button>
            </li>
          </ul>
          <button class="btn-next m-t-button" @click.prevent="dnoneHandler">
            다음
          </button>
        </div>
      </main>
    </section>
  </section>

  <!-- =================== reg2 ======================= -->
  <section class="reg2-form" :class="{ 'd-none': isNext === false }">
    <h1 class="d-none">reg2</h1>

        <section class="canvas-1 d-fl fl-dir-col">

            <h1 class="d-none">reg2</h1>
        
            <!-- =================== reg2 : header ===================== -->
            <header class="">
                
                <div class="reg2-back">
                    <a class="icon icon-back" @click.prevent="dnoneHandler">뒤로가기</a>
                </div>
                
                <div class="hd-title-box">
                    <h1 class="hd-title">글 등록하기</h1>
                </div>
            </header>
    
            <!-- =================== reg2 : main ===================== -->
            <main class="d-fl-jf m-b">

                <form @submit.prevent="upload" method="post" enctype="multipart/form-data" ref="form">
                    <div>
                        <input type="submit" class="reg2-post" value="올리기">
                    </div>

                     <!-- 이미지 업로드  -->
                    <div class="file-box">
                        <label for="file">
                            <div class="btn-file">파일업로드</div>
                            <div class="btn-uploaded-files">
                                파일업로드된 파일들1
                                <div class="btn-uploaded-files" id="result_file">
                                    <img class="uploaded-files" :src="imageURL" />
                                </div>
                            </div>
                            <div class="btn-uploaded-files">파일업로드된 파일들2</div>
                        </label>
    
                        <input type="file" class="d-none" id="file" name="imgs" multiple accept="image/*" @change="uploadImage">
                    </div>

                    <!-- 카테고리 목록 선택 -->
                    <select class="category-box" name="categoryList">
                        <option v-for="c in categoryList" :value="c.id" class="" name="categoryId" v-text="c.name"></option>
                    </select>
                    
                    <div class="select-box">
                        <label for="title" class="input-field-txt">제목</label>
                        <input type="text" class="input-field" id="title" name="title" v-model="stuff.title">
                    </div>
                    
                    
                    <!-- 인원수 조절 -->
                    <div class="select-box2 d-fl">
                        <label for="" class="input-field-txt">인원</label> 
                            <div class="people-count-box">
                                <input class="btn-minus" id="people-count"
                                    type="button" value="" @click.prevent="numPeopleMinusHandler">

                                <input type="text" class="people-count-num" name="numPeople" id="result" v-model="stuff.numPeople">
                                
                                <input class="btn-plus" id="people-count"
                                    type="button" value="" @click.prevent="numPeoplePlusHandler">
                            </div>
                    </div>
                    
                    <!-- 마감일 설정 -->
                    <div id="btn-date" class="select-box d-fl jf-sb">
                        <label for="datetime-local" class="input-field-txt">마감시간</label>
                            <input
                                class="date-pic"
                                type="datetime-local"
                                data-placeholder="날짜를 선택해주세요."
                                required
                                aria-required="true" 
                                name="deadline"
                                className={styles.selectDay}
                                onChange={StartDateValueHandler}
                                v-model="stuff.deadline"
                                >
                                <!-- value={startDateValue} -->
                                <!--  -->
                    </div>


                    <div class="select-box">
                        <label for="price" class="input-field-txt">가격</label>
                        <input type="text" class="input-field" name="price" id="price" v-model="stuff.price">
                    </div>

                    <!-- required 속성: 해당 필드가 기재되었을 때만 submit 가능. -->
                    

                    <!-- 복구용 코드(인원수) -->
                    <!-- <div class="select-box">
                        <label for="people-count" class="input-field-txt">인원수</label>
                        <input type="text" class="input-field" id="people-count">
                    </div> -->

          <!-- 복구용 코드(날짜선택) -->
          <!-- <label for="date" class="input-field-txt">날짜</label>
                        <input type="datetime-local" id="date" class="input-field2" name="date-start"
                        value="2023-02-26"
                        min="2020-01-01" max="2025-12-31"> -->

          <!-- 모달 추가 -->
          <!-- 모달 html -->
          <!-- <div class="select-box btn-open-popup">모달 띄우기</div>
                    <div class="modal">
                        <div class="modal_body">
                            날짜선택
                            <input type="datetime-local" id="date" class="input-field2" name="date-start"
                            value="2023-02-26"
                            min="2020-01-01" max="2025-12-31">
                        </div>
                      </div> -->
          <!-- 모달 JS -->
          <!-- <script>
                        const body = document.querySelector('body');
                        const modal = document.querySelector('.modal');
                        const btnOpenPopup = document.querySelector('.btn-open-popup');
                        //classList 사용은 공백으로 구분된 문자열인 element.className을 통해 
                        //엘리먼트의 클래스 목록에 접근하는 방식을 대체하는 간편한 방법이다.
                        //Element.className : 특정 엘리먼트의 클래스 속성의 값을 가져오거나 설정할 수 있다.
                        btnOpenPopup.addEventListener('click', () => {
                          modal.classList.toggle('show'); //하나의 인수만 있을 때: 클래스 값을 토글링한다. 즉, 클래스가 존재한다면 제거하고 false를 반환하며, 
                                                          //존재하지 않으면 클래스를 추가하고 true를 반환한다.
                          
                          if (modal.classList.contains('show')) { // 지정한 클래스 값이 엘리먼트의 class 속성에 존재하는지 확인한다.
                            body.style.overflow = 'hidden'; // 'show'가 존재한다면 body에서 스크롤 불가.
                          }
                        });
                  
                        modal.addEventListener('click', (event) => {
                          if (event.target === modal) { // .modal 영역을 클릭했다면
                            modal.classList.toggle('show'); // 'show'를 다시 토글(클래스를 제거하고 false를 반환함)
                  
                            if (!modal.classList.contains('show')) { // modal의 클래스에 'show'가 존재하지 않는다면
                              body.style.overflow = 'auto'; // body에서 스크롤이 가능하도록 해라.
                            }
                          }
                        });
                    </script> -->
                           
                    <div class="select-box">
                        <label for="place" class="input-field-txt">장소</label>
                        <input type="text" class="input-field" name="place" id="place" v-model="stuff.place">
                    </div>
    
                    <div class="select-box">
                        <label for="url" class="input-field-txt">링크</label>
                        <input type="text" class="input-field" name="url" id="url" v-model="stuff.url">
                    </div>
    
                    <div class="select-box select-content d-fl fl-dir-col">
                        <label for="content" class="input-field-txt2">내용</label>
                        <textarea class="input-field input-content" name="content" id="content" cols="30" rows="10" v-model="stuff.content"></textarea>
                    </div>
                </form>
            </main>

        </section>
    </section>
</template>

<script>
    export default {
        data() {
            return {
                isNext:false,
                categoryList:[],
                file:[],
                imageURL:'',
                stuff:{
                    title: "아메리카노",
                    place: "이촌동",
                    numPeople: "2",
                    categoryId: 3,
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
                },

            }
        },
        methods: {
            /* reg1 <-> reg2 이동 이벤트 */
            dnoneHandler(){
                this.isNext = !this.isNext;
            },

            /* 인원 수 증감 이벤트 */
            numPeoplePlusHandler(stuff){
		    if(this.stuff.numPeople>=1 && this.stuff.numPeople<16)
		        this.stuff.numPeople++;
            },
            numPeopleMinusHandler(stuff){
                if(this.stuff.numPeople>=2 && this.stuff.numPeople<=16)
                this.stuff.numPeople--;
            },

            /* selectbox에 카테고리 목록 불러오기 */
            loadCategory(){
                var requestOptions = {
                    method: 'GET',
                    redirect: 'follow'
                };
                
                fetch("http://localhost:8080/member/stuffs/categories", requestOptions)
                    .then(response => response.json())
                    .then(categoryList => {
                    console.log(categoryList);
                    this.categoryList = categoryList;
                    })
                    .catch(error => console.log('error', error));
            },

            // 파일 업로드시, 이벤트 처리
            upload(){
                console.log(this.stuff);

                var formData = new FormData(this.$refs.form);

                var requestOptions = {
                    method: 'POST',
                    body: formData,
                    redirect: 'follow'
                };

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
        },
        mounted() {
            this.numPeoplePlusHandler();
            this.numPeopleMinusHandler();

            this.loadCategory();

	    },
        updated(){
            //console.log(this.categoryList.id);
        }
        
    }
</script>

<style scoped>
@import "/css/component/member/stuff/component-reg.css";
</style>
