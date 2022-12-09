<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="cpath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <title>K-WD Dashboard</title>
    <link
    href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&family=Cairo:wght@200;300;400;600;700;900&display=swap"
    rel="stylesheet"
  />
  
    <link rel="stylesheet" href="build/css/tailwind.css" />
    <link rel="stylesheet" href="build/css/test.css" />
    <script src="https://cdn.jsdelivr.net/gh/alpine-collective/alpine-magic-helpers@0.5.x/dist/component.min.js"></script>
    <script src="https://cdn.jsdelivr.net/gh/alpinejs/alpine@v2.7.3/dist/alpine.min.js" defer></script>
  </head>
  <body>
    <div x-data="setup()" x-init="$refs.loading.classList.add('hidden'); setColors(color);" :class="{ 'dark': isDark}">
      <div class="flex h-screen antialiased text-gray-900 bg-gray-100 dark:bg-dark dark:text-light">
        <!-- Loading screen -->
        <div
          x-ref="loading"
          class="fixed inset-0 z-50 flex items-center justify-center text-2xl font-semibold text-white bg-primary-darker"
        >
          Loading.....
        </div>
        <!-- #ff0c6e -->

        <!-- Sidebar -->
        

        <div class="border:1; flex-1 h-full overflow-x-hidden overflow-y-auto" style=" background-color: black; border-bottom: 1px; border-color: white;">
          <!-- Navbar -->
        
          <header id= nav1 class=" justify-between relative bg-white dark:bg-darker " style="background-color: black;">
          <!-- Brand -->
              <a
                class="inline-block text-3xl font-bold tracking-wider uppercase text-primary-dark dark:text-light"
                style="background-color: black;"
              >
               WatchDogs
              </a>
              <div class="justify-between p-4 dark:border-primary-darker" >
             
                <!-- Brand -->
                
         
              <!-- Mobile sub menu -->
              <nav
                x-transition:enter="transition duration-200 ease-in-out transform sm:duration-500"
                x-transition:enter-start="-translate-y-full opacity-0"
                x-transition:enter-end="translate-y-0 opacity-100"
                x-transition:leave="transition duration-300 ease-in-out transform sm:duration-500"
                x-transition:leave-start="translate-y-0 opacity-100"
                x-transition:leave-end="-translate-y-full opacity-0"
                x-show="isMobileSubMenuOpen"
                @click.away="isMobileSubMenuOpen = false"
                class="absolute flex items-center p-4 bg-white rounded-md shadow-lg dark:bg-darker top-16 inset-x-4 md:hidden"
                aria-label="Secondary"
              >
                <div class="space-x-2">
                  <!-- Toggle dark theme button -->
                  <button aria-hidden="true" class="relative focus:outline-none" x-cloak @click="toggleTheme">
                    <div
                      class="w-12 h-6 transition rounded-full outline-none bg-primary-100 dark:bg-primary-lighter"
                    ></div>
                    <div
                      class="absolute top-0 left-0 inline-flex items-center justify-center w-6 h-6 transition-all duration-200 transform scale-110 rounded-full shadow-sm"
                      :class="{ 'translate-x-0 -translate-y-px  bg-white text-primary-dark': !isDark, 'translate-x-6 text-primary-100 bg-primary-darker': isDark }"
                    >
                      <svg
                        x-show="!isDark"
                        class="w-4 h-4"
                        xmlns="http://www.w3.org/2000/svg"
                        fill="none"
                        viewBox="0 0 24 24"
                        stroke="currentColor"
                      >
                        <path
                          stroke-linecap="round"
                          stroke-linejoin="round"
                          stroke-width="2"
                          d="M20.354 15.354A9 9 0 018.646 3.646 9.003 9.003 0 0012 21a9.003 9.003 0 008.354-5.646z"
                        />
                      </svg>
                      <svg
                        x-show="isDark"
                        class="w-4 h-4"
                        xmlns="http://www.w3.org/2000/svg"
                        fill="none"
                        viewBox="0 0 24 24"
                        stroke="currentColor"
                      >
                        <path
                          stroke-linecap="round"
                          stroke-linejoin="round"
                          stroke-width="2"
                          d="M11.049 2.927c.3-.921 1.603-.921 1.902 0l1.519 4.674a1 1 0 00.95.69h4.915c.969 0 1.371 1.24.588 1.81l-3.976 2.888a1 1 0 00-.363 1.118l1.518 4.674c.3.922-.755 1.688-1.538 1.118l-3.976-2.888a1 1 0 00-1.176 0l-3.976 2.888c-.783.57-1.838-.197-1.538-1.118l1.518-4.674a1 1 0 00-.363-1.118l-3.976-2.888c-.784-.57-.38-1.81.588-1.81h4.914a1 1 0 00.951-.69l1.519-4.674z"
                        />
                      </svg>
                    </div>
                  </button>

                 
                </div>
              </nav>
            </div>
            <form action="${cpath}/login" method="post" class="space-y-6">
            <div class="nav1_right" style="padding-right: 20px;">
             <button 
             	type="submit"
            	id="log"
                class="text-3xl font-bold tracking-wider uppercase text-primary-dark dark:text-light"
              >
               Login
              
              </button>
            </div>
           </form>
         
              
             
          </header>

          
          <main>
            


            <!-- Content -->
            <div>
          
              <!-- Charts -->
              <div class="grid p-4 ml-4 lg:grid-cols-2" style="background-color: black;">
                <!-- Bar chart card -->
                <div class="bg-white rounded-md" style="background-color:black ; padding-top: 100px; padding-left: 40px;">
                
                  <!-- Chart -->
                  <h4 class="text-8xl font-bold text-gray-1000 dark:text-light">BlockChain</h4>
                  <h4 class="text-8xl font-bold text-gray-1000 dark:text-light">Data-Based FDS</h4>
                  <h4 class="text-xl font-light text-gray-1000 dark:text-light" style="padding-top: 40px; color: rgb(215, 214, 214);">관계형 데이터베이스와 통합된 유일한 다중 모델 그래프 데이터베이스이므로,</h4>
                  <h4 class="text-xl font-light text-gray-1000 dark:text-light" style="padding-top: 5px; color: rgb(215, 214, 214);">입증된 관계형 데이터베이스 기능, 규모 및 성능을 통해 탁월한 유연성을 제공합니다.</h4>
                  
                </div>

                <!-- Doughnut chart card -->
                <div class="bg-white rounded-md" style="padding-left:50px; background-color: black;" >
                  <img src="./build/images/jel.jpg" width="600px" height="450px">
                
                </div>
              </div>


              <div class="grid cols-1 lg:grid-cols-1"> 
                <div class="bg-white rounded-md mt-4 "style="padding-top: 110px ;padding-bottom:30px; background-color:black;">
                  <!-- Chart -->  
                    <h4 class="text-3xl text-gray-500 dark:text-light" style="text-align:center; color:rgb(249, 237, 6);">Trusted by 2,400+ Global Organizations</h4>
                </div>
              </div>
              <div class="grid cols-1 p-4 lg:grid-cols-1 h-offset" style="width:100%; height:350px; background-color:rgb(71, 128, 171);">
                <div class="slider" >
                  <div class="slide-track" >
                      <div class="slide" >
                          <img src="./build/images/UPBIT LAST.jpg" style="padding-top:100px; padding-right: 50px;" height="230" width="350" alt="" />
                      </div>
                      <div class="slide">
                          <img src="./build/images/SMART LAST.jpg" style="padding-top: 0px;padding-right: 50px;" height="230" width="350" alt="" />
                      </div>
                      <div class="slide">
                          <img src="build/images/NEO4J LAST.png" style="padding-top: 75px;padding-right: 50px;" height="280" width="350" alt="" />
                      </div>
                      <div class="slide">
                          <img src="./build/images/COINONE LAST.png" style="padding-top: 65px; padding-right: 50px;" height="230" width="350" alt="" />
                      </div>
                      <div class="slide">
                          <img src="./build/images/BITCOIN LAST.png" style="padding-top:95px; padding-right: 50px;" height="244" width="500" alt="" />
                      </div>
                      <div class="slide">
                          <img src="./build/images/BITNINE LAST.png" style="padding-top: 92px; padding-right: 50px;" height="230" width="350" alt="" />
                      </div>
                      <div class="slide">
                          <img src="./build/images/BITTHUMB LAST.png" style="padding-top: 87px; padding-right: 50px;" height="230" width="350" alt="" />
                      </div>
                      <div class="slide">
                        <img src="./build/images/UPBIT LAST.jpg" style="padding-top:100px; padding-right: 50px;" height="230" width="350" alt="" />
                    </div>
                    <div class="slide">
                        <img src="./build/images/SMART LAST.jpg" style="padding-top: 0px;" height="230" width="350" alt="" />
                    </div>
                    <div class="slide">
                        <img src="build/images/NEO4J LAST.png" style="padding-top: 75px; padding-right: 50px;" height="280" width="350" alt="" />
                    </div>
                    <div class="slide">
                        <img src="./build/images/COINONE LAST.png" style="padding-top: 65px;padding-right: 50px; " height="230" width="350" alt="" />
                    </div>
                    <div class="slide">
                        <img src="./build/images/BITCOIN LAST.png" style="padding-top:95px;padding-right: 50px;" height="244" width="500" alt="" />
                    </div>
                    <div class="slide">
                        <img src="./build/images/BITNINE LAST.png" style="padding-top: 92px; padding-right: 50px;" height="230" width="350" alt="" />
                    </div>
                    <div class="slide">
                        <img src="./build/images/BITTHUMB LAST.png" style="padding-top: 87px;padding-right: 50px;" height="230" width="350" alt="" />
                    </div>  
                      
                      
                  </div>

              </div>
              <!-- <div class="banner">
              </div> -->
              </div>

              <div class="grid cols-1 p-4 lg:grid-cols-2">

                  <!-- Doughnut chart card -->
                <div class="bg-white rounded-md" style="padding:100px;background-color: black;" >
                  <img src="./build/images/fr.png" width="430px">
                  <!-- Chart -->
                   
                </div>

                <div class=" bg-white rounded-md pr-4" style="text-align: right; padding-top: 200px; background-color: black;"> 
                  <!-- Chart -->
                  <h4 class="text-8xl font-bold text-gray-500 dark:text-light">Fraud Detection</h4>
                  <h4 class="text-xl pt-4 font-light text-gray-500 dark:text-light" style="padding-top:40px; color: rgb(215, 214, 214)">그래프 기술은 정보 네트워크 전체에 숨겨진 이상 현상을 발견합니다.</h4>
                  <h4 class="text-xl font-light text-gray-500 dark:text-light" style="padding-top:5px; color: rgb(215, 214, 214)">사기 탐지 솔루션은 사기 링에서 발견되는 의심스러운 행동을 탐지하고 방지합니다.</h4>
                </div>
 
              </div>
              <div class="grid cols-1" style="background-color: black;">

              </div>
              <div class="grid cols-1 p-4 lg:grid-cols-2">
                <div class=" bg-white rounded-md pr-4" style="text-align: left; padding-top: 200px; background-color: black;"> 
                  <!-- Chart -->
                  <h4 class="text-8xl font-bold text-gray-500 dark:text-light" style="padding-left: 40px;">지갑 조회</h4>
                  <h4 class="text-xl pt-4 font-light text-gray-500 dark:text-light" style="padding-top:40px; padding-left: 40px; color: rgb(215, 214, 214)">모든 분석 요구 사항을 충족하는 상호 조작 및 재구성을 통해</h4>
                  <h4 class="text-xl font-light text-gray-500 dark:text-light" style="padding-top:5px;padding-left: 40px; color: rgb(215, 214, 214)">다양한 그래프 토폴로지 및 레이아웃과 상호적이고 직관적인 지갑정보를 제공합니다.</h4>
                </div>

                <!-- Doughnut chart card -->
              <div class="bg-white rounded-md" style="padding:100px;background-color: black;" >
                <img src="./build/images/wallet.png" width="420px" style="padding-left: 100px;">
                <!-- Chart -->
                 
              </div>

              

            </div>
        
              </div>
            </div>          

           </main>

          <!-- Main footer -->
          
     
        
        
      </div>
    </div>

    <!-- All javascript code in this project for now is just for demo DON'T RELY ON IT  -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.bundle.min.js"></script>
    <script src="build/js/script.js"></script>
    <script>
      const setup = () => {
        const getTheme = () => {
          if (window.localStorage.getItem('dark')) {
            return JSON.parse(window.localStorage.getItem('dark'))
          }

          return !!window.matchMedia && window.matchMedia('(prefers-color-scheme: dark)').matches
        }

        const setTheme = (value) => {
          window.localStorage.setItem('dark', value)
        }

        const getColor = () => {
          if (window.localStorage.getItem('color')) {
            return window.localStorage.getItem('color')
          }
          return 'cyan'
        }

        const setColors = (color) => {
          const root = document.documentElement
          root.style.setProperty('--color-primary', `var(--color-${color})`)
          root.style.setProperty('--color-primary-50', `var(--color-${color}-50)`)
          root.style.setProperty('--color-primary-100', `var(--color-${color}-100)`)
          root.style.setProperty('--color-primary-light', `var(--color-${color}-light)`)
          root.style.setProperty('--color-primary-lighter', `var(--color-${color}-lighter)`)
          root.style.setProperty('--color-primary-dark', `var(--color-${color}-dark)`)
          root.style.setProperty('--color-primary-darker', `var(--color-${color}-darker)`)
          this.selectedColor = color
          window.localStorage.setItem('color', color)
          //
        }

        const updateBarChart = (on) => {
          const data = {
            data: randomData(),
            backgroundColor: 'rgb(207, 250, 254)',
          }
          if (on) {
            barChart.data.datasets.push(data)
            barChart.update()
          } else {
            barChart.data.datasets.splice(1)
            barChart.update()
          }
        }

        const updateDoughnutChart = (on) => {
          const data = random()
          const color = 'rgb(207, 250, 254)'
          if (on) {
            doughnutChart.data.labels.unshift('Seb')
            doughnutChart.data.datasets[0].data.unshift(data)
            doughnutChart.data.datasets[0].backgroundColor.unshift(color)
            doughnutChart.update()
          } else {
            doughnutChart.data.labels.splice(0, 1)
            doughnutChart.data.datasets[0].data.splice(0, 1)
            doughnutChart.data.datasets[0].backgroundColor.splice(0, 1)
            doughnutChart.update()
          }
        }

        const updateLineChart = () => {
          lineChart.data.datasets[0].data.reverse()
          lineChart.update()
        }

        return {
          loading: true,
          isDark: getTheme(),
          toggleTheme() {
            this.isDark = !this.isDark
            setTheme(this.isDark)
          },
          setLightTheme() {
            this.isDark = false
            setTheme(this.isDark)
          },
          setDarkTheme() {
            this.isDark = true
            setTheme(this.isDark)
          },
          color: getColor(),
          selectedColor: 'cyan',
          setColors,
          toggleSidbarMenu() {
            this.isSidebarOpen = !this.isSidebarOpen
          },
          isSettingsPanelOpen: false,
          openSettingsPanel() {
            this.isSettingsPanelOpen = true
            this.$nextTick(() => {
              this.$refs.settingsPanel.focus()
            })
          },
          isNotificationsPanelOpen: false,
          openNotificationsPanel() {
            this.isNotificationsPanelOpen = true
            this.$nextTick(() => {
              this.$refs.notificationsPanel.focus()
            })
          },
          isSearchPanelOpen: false,
          openSearchPanel() {
            this.isSearchPanelOpen = true
            this.$nextTick(() => {
              this.$refs.searchInput.focus()
            })
          },
          isMobileSubMenuOpen: false,
          openMobileSubMenu() {
            this.isMobileSubMenuOpen = true
            this.$nextTick(() => {
              this.$refs.mobileSubMenu.focus()
            })
          },
          isMobileMainMenuOpen: false,
          openMobileMainMenu() {
            this.isMobileMainMenuOpen = true
            this.$nextTick(() => {
              this.$refs.mobileMainMenu.focus()
            })
          },
          updateBarChart,
          updateDoughnutChart,
          updateLineChart,
        }
      }
      <!--nav1 bar-->
      const nav1
       = document.getElementById('nav1');
      
      window.addEventListener('scroll', () => {
        
        if(window.scrollY >=100){
          // background-image : linear-gradient(180deg,rgba(0,0,0,.7) 10%,transparent);
          // console.log("123")
          nav1.classList.add('nav__black');
        } else{

          nav1.classList.remove('nav__black');
        }
      });
	//로그인 페이지 이동
	$(document).ready(function(){
	       $("#log").click(function(){
	           location.href="login";
	        });
	
	    });
	
	


    

 
    </script>
  </body>
</html>
