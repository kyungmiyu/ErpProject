<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
<link rel="icon" type="image/png" href="assets/img/favicon.png">
<title>ERP PROJECT</title>

<!--     Fonts and icons     -->
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet" />
<!-- Nucleo Icons -->
<link href="assets/css/nucleo-icons.css" rel="stylesheet" />
<link href="assets/css/nucleo-svg.css" rel="stylesheet" />

<!-- Font Awesome Icons -->
<script defer src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
<link href="assets/css/nucleo-svg.css" rel="stylesheet" />
<!-- CSS Files -->
<link id="pagestyle" href="assets/css/argon-dashboard.css?v=2.0.4" rel="stylesheet" />
<!-- Github buttons -->
<script async defer src="https://buttons.github.io/buttons.js"></script>
<!-- Control Center for Soft Dashboard: parallax effects, scripts for the example pages etc -->
<script defer src="assets/js/argon-dashboard.min.js?v=2.0.4"></script>

<!-- Google Icons -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<!--
=========================================================
* Argon Dashboard 2 - v2.0.4
=========================================================

* Product Page: https://www.creative-tim.com/product/argon-dashboard
* Copyright 2022 Creative Tim (https://www.creative-tim.com)
* Licensed under MIT (https://www.creative-tim.com/license)
* Coded by Creative Tim

=========================================================

* The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
-->
</head>
<body>
 	<div class="min-height-300 bg-primary position-absolute w-100"></div>
 	<!-- Sidebar -->
  	<%@ include file="./sidebar.jsp"%>
	<main class="main-content position-relative border-radius-lg ">
 	<!-- Header -->
 	<%@ include file="./header.jsp"%> 
    <div class="comm-body container-fluid py-4">
    
      <div class="row mt-4">
        <div class="col-lg-7 mb-lg-0 mb-4">
          <div class="card z-index-2 h-100">
            <div class="card-header pb-0 pt-3 bg-transparent">
              <h6 class="text-capitalize">Department Team overview</h6>
              <p class="text-sm mb-0">
                <i class="fa fa-arrow-up text-success" aria-hidden="true"></i>
                <span class="font-weight-bold">4% more</span> in 2023
              </p>
            </div>
            <div class="card-body p-3">
              <div class="chart">
                <canvas id="chart-line" class="chart-canvas" height="375" width="606" style="display: block; box-sizing: border-box; height: 300px; width: 485.1px;"></canvas>
              </div>
            </div>
          </div>
        </div>
        <div class="col-lg-5">
          <div class="card card-carousel overflow-hidden h-100 p-0">
            <div id="carouselExampleCaptions" class="carousel slide h-100" data-bs-ride="carousel">
              <div class="carousel-inner border-radius-lg h-100">
                <div class="carousel-item h-100 active" style="background-image: url('./assets/img/member/member1.jpg');
      background-size: cover;">
                  <div class="carousel-caption d-none d-md-block bottom-0 text-start start-0 ms-5">
                    <div class="icon icon-shape icon-sm bg-white text-center border-radius-md mb-3">
                      <i class="ni ni-single-02 text-dark opacity-10"></i>
                    </div>
                    <h5 class="text-white mb-1">Get started with Member</h5>
                    <p>There’s nothing I really wanted to do in life that I wasn’t able to get good at.</p>
                  </div>
                </div>
                <div class="carousel-item h-100" style="background-image: url('./assets/img/member/member2.png');
      background-size: cover;">
                  <div class="carousel-caption d-none d-md-block bottom-0 text-start start-0 ms-5">
                    <div class="icon icon-shape icon-sm bg-white text-center border-radius-md mb-3">
                      <i class="ni ni-single-02 text-dark opacity-10"></i>
                    </div>
                    <h5 class="text-white mb-1">Get started with Member</h5>
                    <p>That’s my skill. I’m not really specifically talented at anything except for the ability to learn.</p>
                  </div>
                </div>
                <div class="carousel-item h-100" style="background-image: url('./assets/img/member/member3.png');
      background-size: cover;">
                  <div class="carousel-caption d-none d-md-block bottom-0 text-start start-0 ms-5">
                    <div class="icon icon-shape icon-sm bg-white text-center border-radius-md mb-3">
                      <i class="ni ni-single-02 text-dark opacity-10"></i>
                    </div>
                    <h5 class="text-white mb-1">Get started with Member</h5>
                    <p>Don’t be afraid to be wrong because you can’t learn anything from a compliment.</p>
                  </div>
                </div>
                <div class="carousel-item h-100 active" style="background-image: url('./assets/img/member/member4.png');
      background-size: cover;">
                  <div class="carousel-caption d-none d-md-block bottom-0 text-start start-0 ms-5">
                    <div class="icon icon-shape icon-sm bg-white text-center border-radius-md mb-3">
                      <i class="ni ni-single-02 text-dark opacity-10"></i>
                    </div>
                    <h5 class="text-white mb-1">Get started with Member</h5>
                    <p>There’s nothing I really wanted to do in life that I wasn’t able to get good at.</p>
                  </div>
                </div>
                <div class="carousel-item h-100 active" style="background-image: url('./assets/img/member/member5.png');
      background-size: cover;">
                  <div class="carousel-caption d-none d-md-block bottom-0 text-start start-0 ms-5">
                    <div class="icon icon-shape icon-sm bg-white text-center border-radius-md mb-3">
                      <i class="ni ni-single-02 text-dark opacity-10"></i>
                    </div>
                    <h5 class="text-white mb-1">Get started with Member</h5>
                    <p>There’s nothing I really wanted to do in life that I wasn’t able to get good at.</p>
                  </div>
                </div>
                <div class="carousel-item h-100 active" style="background-image: url('./assets/img/member/member6.png');
      background-size: cover;">
                  <div class="carousel-caption d-none d-md-block bottom-0 text-start start-0 ms-5">
                    <div class="icon icon-shape icon-sm bg-white text-center border-radius-md mb-3">
                      <i class="ni ni-single-02 text-dark opacity-10"></i>
                    </div>
                    <h5 class="text-white mb-1">Get started with Member</h5>
                    <p>There’s nothing I really wanted to do in life that I wasn’t able to get good at.</p>
                  </div>
                </div>
                <div class="carousel-item h-100 active" style="background-image: url('./assets/img/member/member7.png');
      background-size: cover;">
                  <div class="carousel-caption d-none d-md-block bottom-0 text-start start-0 ms-5">
                    <div class="icon icon-shape icon-sm bg-white text-center border-radius-md mb-3">
                      <i class="ni ni-single-02 text-dark opacity-10"></i>
                    </div>
                    <h5 class="text-white mb-1">Get started with Member</h5>
                    <p>There’s nothing I really wanted to do in life that I wasn’t able to get good at.</p>
                  </div>
                </div>
              </div>
              <button class="carousel-control-prev w-5 me-3" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
              </button>
              <button class="carousel-control-next w-5 me-3" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
              </button>
            </div>
          </div>
        </div>
      </div>

    </div> 
   	
   	<!-- Footer -->
   	<%@ include file="./footer.jsp"%> 
  </main>
  <!--   Back to Top   -->
  <div class="fixed-plugin">
    <a class="fixed-plugin-button text-dark position-fixed px-3 py-2">
      <i class="ni ni-bold-up"></i>
    </a>
  </div>
  
<!--   Core JS Files   -->
  <script src="./assets/js/core/popper.min.js"></script>
  <script src="./assets/js/core/bootstrap.min.js"></script>
  <script src="./assets/js/plugins/perfect-scrollbar.min.js"></script>
  <script src="./assets/js/plugins/smooth-scrollbar.min.js"></script>
  <script src="./assets/js/plugins/chartjs.min.js"></script>
<script src="assets/js/plugins/chartjs.min.js"></script>
<script>
	var ctx1 = document.getElementById("chart-line").getContext("2d");
	
	var gradientStroke1 = ctx1.createLinearGradient(0, 230, 0, 50);
	
	gradientStroke1.addColorStop(1, 'rgba(94, 114, 228, 0.2)');
	gradientStroke1.addColorStop(0.2, 'rgba(94, 114, 228, 0.0)');
	gradientStroke1.addColorStop(0, 'rgba(94, 114, 228, 0)');
	new Chart(ctx1, {
	  type: "line",
	  data: {
	    labels: ["경영팀", "인사팀", "구매팀", "생산팀", "물류팀", "영업팀"],
	    datasets: [{
	      label: "Mobile apps",
	      tension: 0.4,
	      borderWidth: 0,
	      pointRadius: 0,
	      borderColor: "#5e72e4",
	      backgroundColor: gradientStroke1,
	      borderWidth: 3,
	      fill: true,
	      data: [150, 300, 220, 450, 250, 400, 230],
	      maxBarThickness: 6
	
	    }],
	  },
	  options: {
	    responsive: true,
	    maintainAspectRatio: false,
	    plugins: {
	      legend: {
	        display: false,
	      }
	    },
	    interaction: {
	      intersect: false,
	      mode: 'index',
	    },
	    scales: {
	      y: {
	        grid: {
	          drawBorder: false,
	          display: true,
	          drawOnChartArea: true,
	          drawTicks: false,
	          borderDash: [5, 5]
	        },
	        ticks: {
	          display: true,
	          padding: 10,
	          color: '#fbfbfb',
	          font: {
	            size: 11,
	            family: "Open Sans",
	            style: 'normal',
	            lineHeight: 2
	          },
	        }
	      },
	      x: {
	        grid: {
	          drawBorder: false,
	          display: false,
	          drawOnChartArea: false,
	          drawTicks: false,
	          borderDash: [5, 5]
	        },
	        ticks: {
	          display: true,
	          color: '#ccc',
	          padding: 20,
	          font: {
	            size: 11,
	            family: "Open Sans",
	            style: 'normal',
	            lineHeight: 2
	          },
	        }
	      },
	    },
	  },
	});
</script>
</body>
</html>