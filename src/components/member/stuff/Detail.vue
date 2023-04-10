<script>
export default {
  data() {
    return {
      openModal: false,
      stuff: {},
    };
  },
  methods: {
    /* 모달 이벤트 */
    modalHandler() {
      this.openModal = !this.openModal;
    },
  },
  mounted() {
    fetch(`http://localhost:8080/member/stuffs/${this.$route.params.id}`)
      .then((response) => response.json())
      .then((stuff) => (this.stuff = stuff))
      .catch((error) => console.log("error", error));
  },
  updated() {
    console.log(this.stuff);
  },
};
</script>

<style scoped></style>

<template>
  <!-- detail : flex-container -->
  <div class="detail">
    <header>
      <router-link router-link to="list" class="icon icon-back"
        >뒤로가기</router-link
      >
    </header>
    <!-- detail - item1  -->
    <main>
      <!-- detail-main : flex-container -->
      <div class="detail-main">
        <!-- detail-img : detail-main - item1 -->
        <div class="detail-img">
          <img src="../../../../images/member/stuff/chick.jpg" alt="img" />

          <!-- image : modal -->
          <div class="detail-modal">
            <div
              class="icon-close"
              src="../../images/member/stuff/heart.png"
            ></div>
            <!-- <img class="icon-close" src="../../images/member/stuff/heart.png"> -->
            <img class="modal-img" />
          </div>

          <!-- image : slideshow -->
        </div>

        <!-- detail-heading : detail-main - item2 -->
        <section class="canvas detail-heading">
          <h1 class="d-none">heading</h1>
          <div class="detail-category">대형마트 대량 물품</div>
          <p class="detail-heading-title">{{ stuff.title }}</p>
          <div class="d-fl">
            <div class="detail-price">{{ stuff.price }}</div>
            <div class="detail-status">모집중</div>
            <div class="detail-heart">찜</div>
            <div class="icon-heart">하트</div>
          </div>
        </section>
        <!-- detail-info : detail-main - item3 -->
        <section class="canvas detail-info">
          <h1 class="d-none">info</h1>
          <div>•인원</div>
          <div>2 / {{ stuff.numPeople }}</div>
          <div>•기한</div>
          <div>{{ stuff.deadline }}</div>
          <div>•장소</div>
          <div>{{ stuff.place }}</div>
        </section>
        <!-- detail-writing : detail-main - item4 -->
        <section class="canvas detail-writing">
          <h1 class="d-none">writing</h1>
          <p class="detail-paragraph">
            {{ stuff.content }}
          </p>
        </section>
      </div>
    </main>

    <!-- detail-join : detail - itme2  -->

    <section class="canvas detail-join">
      <h1 class="d-none">join</h1>
      <h2 class="detail-join-title">참여중인 사람</h2>
      <div class="detail-join-members">
        <a class="icon-member">멤버a</a>
        <a class="icon-member">멤버b</a>
        <a class="icon-member">멤버c</a>
        <a class="icon-member">멤버d</a>
        <a class="icon-member">멤버e</a>
      </div>
      <button class="detail-join-button" onclick="location.href='list.html'">
        참여하기
      </button>
    </section>

    <!-- 모달버튼 -->
    <div>
      <div @click="openModal = true" class="btn-default">수정</div>
      <div @click="openModal = true" class="btn-default">삭제</div>
    </div>  
  </div>

  <!-- 수정/삭제 모달 -->
  <div class="black-bg" v-if="openModal == true">
    <div class="white-bg">
      <h1>모달 테스트</h1>
      <p>수정</p>
      <p>삭제</p>
      <button class="close-button" @click.prevent="modalHandler">닫기</button>
    </div>
  </div>
</template>

<style scoped>
@import "/css/component/member/stuff/component-detail.css";
</style>
