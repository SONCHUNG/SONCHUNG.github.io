<script>

export default {
	data() {
		return {
			list: '',
			page: '',
			categoryList: ''
		};
	},
	methods: {
		addListHandler() {
			this.page++;
			fetch(`http://localhost:8080/member/stuffs?p=${this.page}`)
				.then(response => response.json())
				.then(list => {
					this.list = list;
					console.log(list);
				})
				.catch(error => console.log('error', error));
		},
		categoryLoad() {
			fetch("http://localhost:8080/member/stuffs/categories")
				.then(response => response.json())
				.then(categoryList => this.categoryList = categoryList)
				.catch(error => console.log('error', error));
		},
	},
	mounted() {
		this.page = 0;
		this.addListHandler();
		this.categoryLoad();
		console.log(this.list);
	}
}
</script>
<script>
export default {
    data() {
        return {
            list:[],
            categoryList:[]
        };
    },
    methods: {
        load(){
            fetch("http://localhost:8080/member/stuffs")
            .then(response => response.json())
            .then(list => this.list = list)
            .catch(error => console.log('error', error));
        },
        categoryLoad(){
            fetch("http://localhost:8080/member/stuffs/categories")
            .then(response => response.json())
            .then(categoryList => this.categoryList = categoryList)
            .catch(error => console.log('error', error));
        },
    },
    mounted() {
        this.load()
        this.categoryLoad()
    },
}
</script>
<style scoped>
@import url(/css/component/member/stuff/component-list.css);
</style>
<template>
	<section class="canvas p-rel b-rad-2">
		<header class="d-fl-al header-jc">
			<select class="selectbox-set" onchange="if(this.value) location.href=(this.value);">
				<option value="">신수동</option>
				<option value="">신설동</option>
				<option value="/member/stuff/gps">GPS설정</option>
			</select>

			<div>
				<!-- <a class="icon icon-menu">메뉴</a> -->
				<a class="icon icon-alarm">알림</a>
				<a class="icon">
					<input type="checkbox" id="menuicon">
					<label for="menuicon">
						<span></span>
						<span></span>
						<span></span>
					</label>
					<div class="sidebar">
						<div class="welcome f-weight">
							<span class="f-color-2">뉴렉님</span><br>환영합니다.
						</div>
						<div class="side-menu">
							<div></div>
							<span class="sidebar-padding" onclick="location.href='list.html'">홈</span>
							<span class="sidebar-padding" onclick="location.href='list-search.html'">검색하기</span>
							<span class="sidebar-padding" onclick="location.href='reg.html'">글 등록하기</span>
							<span class="sidebar-padding" onclick="location.href='../participation/list.html'">채팅하기</span>
						</div>
					</div>
				</a>
			</div>
		</header>

		<nav>
			<form action="list.html" method="get" class="header-categ-box">
				<div>
					<button class="header-categ" name="c">전체</button>
				</div>

				<div v-for="c in categoryList">
					<button class="header-categ" name="c" :value="c.id">{{ c.name }}</button>
				</div>
			</form>
		</nav>

		<!-- 나중에 onclick 이벤트 하트 부분만 빼고 넣기 -->
		<main>
			<div class="stuff-list" v-for="stuff in list">
				<router-link :to="'./' + stuff.id">
					<div class="d-gr li-gr m-t-13px list-cl" onclick="location.href='detail.html'">
						<!-- 나중에 전체를 div로 묶어서 main으로 크게 묶기 -->
						<div class="li-pic b-rad-1">사진</div>
						<div class="li-categ header-categ li-header-categ">{{ stuff.categoryName }}</div>
						<div class="li-heart icon icon-heart">
							찬하트
						</div>
						<div class="li-subj">{{ stuff.title }}</div>
						<div class="li-member"> 1 / {{ stuff.numPeople }}</div>
						<div class="li-date">{{ stuff.deadline }}</div>
					</div>
					<div>
						<h1 class="icon icon-line">선 긋기</h1>
					</div>
				</router-link>
			</div>

		</main>

		<nav class="navi-bar d-fl-jf" style="display: none;">
			<div>
				<router-link class="icon icon-home m-notop" to="./list">home</router-link>
			</div>
			<div>
				<a class="icon icon-search m-notop" href="./list-search.html">search</a>
			</div>
			<div>
				<a class="icon icon-post m-notop" href="./reg.html">post+</a>
			</div>
			<div>
				<a class="icon icon-chat m-notop" href="../participation/list.html">chat</a>
			</div>
			<div>
				<a class="icon icon-info m-notop">mypage</a>
			</div>
		</nav>
	</section>
</template>


<style scoped>
@import "/css/component/member/stuff/component-list.css";

.reg-stuff {
	width: 30px;
	height: 30px;
	background-color: #63A0C2;
	color: #fff;
	border-radius: 50%;
	text-align: center;
	line-height: 30px;
	position: fixed;
	right: 30px;
	bottom: 30px;
	cursor: pointer;
}
</style>