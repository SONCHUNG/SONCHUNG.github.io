<template>
    <body>
        <!-- =================== reg1 ======================= -->
        <section class="reg1-form">
            <h1 class="d-none">reg1</h1>
    
            <section class="canvas-1 d-fl fl-dir-col">
                <!-- =================== reg1 : header ===================== -->
                <header class="d-fl">
                    
                    <div>
                        <a href="./list.html" class="icon icon-back">뒤로가기</a>
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
                            <li><button class="select-box categ-eff" name="merchandise">일반상품</button></li>
                            <li><button class="select-box categ-eff" name="supermarket">대형마트 대량 물품</button></li>
                            <li><button class="select-box categ-eff" name="delivery_food">딜리버리 푸드</button></li>
                        </ul>
                        <button class="btn-next m-t-button">다음</button>
                    </div>
                </main>
        
            </section>
      </section>
    
        <!-- =================== reg2 ======================= -->
        <section class="reg2-form d-none">
            <h1 class="d-none">reg2</h1>
    
            <section class="canvas-1 d-fl fl-dir-col">
    
                <h1 class="d-none">reg2</h1>
                <!-- header에 id를 부여해줄 것 - id는 html 짠사람이 부여해주기 때문이다! 이거로 css 경로 부여! -->
            
                <!-- =================== reg2 : header ===================== -->
                <header class="">
                    
                    <div class="reg2-back">
                        <a class="icon icon-back">뒤로가기</a>
                    </div>
                    
                    <div class="hd-title-box">
                        <h1 class="hd-title">글 등록하기</h1>
                    </div>
                </header>
        
                <!-- =================== reg2 : main ===================== -->
                <main class="d-fl-jf m-b">
                    
                    <!-- form method post로 수정하기! -->
                    <form action="./list.html" method="get" enctype="multipart/form-data">
            
                        <div>
                            <input type="submit" class="reg2-post" value="올리기">
                        </div>
                        
                        <div class="file-box">
                            <!-- 파일업로드 버튼 만드는 법 -->
                            <label for="file">
                                <div class="btn-file">파일업로드</div>
                                <div class="btn-uploaded-files">파일업로드된 파일들1</div>
                                <div class="btn-uploaded-files">파일업로드된 파일들2</div>
                            </label>
        
                            <input type="file" class="d-none" id="file" name="file" multiple>
                        </div>
    
                        <!-- 기존 카테고리 -->
                        <select class="category-box" name="category_list">
                            
                            <!-- 타임리프 each 이용 --> 
                            <option class="" value="merchandise" name="merchandise">일반상품</option>
                            <option class="" value="supermarket" name="supermarket">대형마트 대량 물품</option>
                            <option class="" value="delivery_food" name="delivery_food">딜리버리 푸드</option>
                        </select>
    
                        <!-- 가로 스크롤 수정하기 -->
                        <div class="select-box">
                            <label for="title" class="input-field-txt">제목</label>
                            <input type="text" class="input-field" id="title" name="title">
                        </div>
                        
                        
                        <div class="select-box2 d-fl">
                            <label for="" class="input-field-txt">인원</label> 
                                <div class="people-count-box">
                                    <input class="btn-minus" id="people-count"
                                        type="button" onclick='count("minus")' value="">
                                    <input type="text" class="people-count-num" name="numPeople" id="result" value=2>
                                    
                                    <input class="btn-plus" id="people-count"
                                        type="button" onclick='count("plus")' value="">
                                </div>
                        </div>
                        
                        <!-- 인원수 조절 JS -->
                        <!-- <script>
                            function count(type)  {
                              // 결과를 표시할 element
                              const resultElement = document.getElementById('result');
                              // 현재 화면에 표시된 값
                              let number = resultElement.innerText;
                              // 더하기/빼기
                              if(type === 'plus') {
                                number = parseInt(number) + 1;
                              }else if(type === 'minus')  {
                                number = parseInt(number) - 1;
                              }
                              // 결과 출력
                              resultElement.innerText = number;
                            }
                            </script> -->
                            
                     <div id="btn-date" class="select-box d-fl jf-sb">
                        <label for="datetime-local" class="input-field-txt">마감시간</label>
                            <input
                                class="date-pic"
                                type="datetime-local"
                                data-placeholder="날짜를 선택해주세요."
                                required
                                aria-required="true" 
                                value={startDateValue}
                                className={styles.selectDay}
                                onChange={StartDateValueHandler}
                                >
                        </div>
    
    
                        <div class="select-box">
                            <label for="price" class="input-field-txt">가격</label>
                            <input type="text" class="input-field" name="price" id="price">
                        </div>
                               
                        <div class="select-box">
                            <label for="place" class="input-field-txt">장소</label>
                            <input type="text" class="input-field" name="place" id="place">
                        </div>
        
                        <div class="select-box">
                            <label for="url" class="input-field-txt">링크</label>
                            <input type="text" class="input-field" name="url" id="url">
                        </div>
        
                        <div class="select-box select-content d-fl fl-dir-col">
                            <label for="content" class="input-field-txt2">내용</label>
                            <textarea class="input-field input-content" name="content" id="content" cols="30" rows="10"></textarea>
                        </div>
                    </form>
                </main>
    
            </section>
        </section >
    </body>
</template>



<style scoped>
@import '../assets/component/member/stuff/component-reg.css';
</style>