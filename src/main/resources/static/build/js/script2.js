// All javascript code in this project for now is just for demo DON'T RELY ON IT


const transactions = ['Normal', 'Fraud']

const cssColors = (color) => {
	return getComputedStyle(document.documentElement).getPropertyValue(color)
}

const getColor = () => {
	return window.localStorage.getItem('color') ?? 'cyan'
}

const colors = {
	primary: cssColors(`--color-${getColor()}`),
	primaryLight: cssColors(`--color-${getColor()}-light`),
	primaryLighter: cssColors(`--color-${getColor()}-lighter`),
	primaryDark: cssColors(`--color-${getColor()}-dark`),
	primaryDarker: cssColors(`--color-${getColor()}-darker`),
}

$(document).ready(function() {
	$("#csv_button").click(function(event) {
		//event.preventDefault();
		var user_csv_form = $("#user_csv_form")[0];
		var csv_form = new FormData(user_csv_form);
		var count = 3;
		
		$.ajax({
			url: 'search_cnt',
			type: 'post',
			success: function(res) {
				console.log(res);
				if(res>2){
					alert("조회수가 3이 넘었습니다 구독후 이용해주세요.");
					location.href="Subcribe";
				}else{ 
					var realcount = 3-res;
					alert("앞으로 이용가능한 진단횟수는"+realcount+"번입니다.");
					$.ajax({
						url: 'http://127.0.0.1:5000/user_csv',
						async: false,
						type: 'post',
						data: csv_form,
						dataType: 'json',
						cache: false,
						contentType: false,
						processData: false,
						success: function(res) {
							console.log(res);
							
							// 도넛그래프
							const normal = [];
							const abnormal = [];
							for (let i = 0; i < res[0].length; i++) {
								if (res[0][i] == "0") {
									normal.push("0");
								} else if (res[0][i] == "1") {
									abnormal.push("1");
								}
							}
							const doughnutChart = new Chart(document.getElementById('doughnutChart'), {
								type: 'doughnut',
								data: {
									labels: ['normal', 'Fraud'],
									datasets: [
										{
											data: [normal.length, abnormal.length],
											backgroundColor: [colors.primary, colors.primaryLighter],
											hoverBackgroundColor: colors.primaryDark,
											borderWidth: 0,
											weight: 0.5,
										},
									],
								},
								options: {
									responsive: true,
									maintainAspectRatio: false,
									legend: {
										position: 'bottom',
									},
			
									title: {
										display: false,
									},
									animation: {
										animateScale: true,
										animateRotate: true,
									},
								},
							})
			
							// 막대그래프
							for (let i = 0; i < res[1].length; i++) {
								const barChart = new Chart(document.getElementById('barChart' + i), {
									type: 'bar',
									data: {
										labels: transactions,
										datasets: [
											{
												data: [res[1][i], res[2][i]],
												backgroundColor: colors.primary,
												hoverBackgroundColor: colors.primaryDark,
											},
										],
									},
									options: {
										scales: {
											yAxes: [
												{
													gridLines: false,
													ticks: {
														beginAtZero: true,
														stepSize: 50,
														fontSize: 12,
														fontColor: '#97a4af',
														fontFamily: 'Open Sans, sans-serif',
														padding: 10,
													},
												},
											],
											xAxes: [
												{
													gridLines: false,
													ticks: {
														fontSize: 12,
														fontColor: '#97a4af',
														fontFamily: 'Open Sans, sans-serif',
														padding: 5,
													},
													categoryPercentage: 0.5,
													maxBarThickness: '50',
												},
											],
										},
										cornerRadius: 2,
										maintainAspectRatio: false,
										legend: {
											display: false,
										},
									},
								})
							}
			
							// G-FDS 관계그래프
							$("#listDiv").html(res[3]);
							
							$.ajax({
								url: 'use_cnt',
								type: 'post',
								success: function(res) {
									if (res===1){
									console.log("업데이트성공");
									} else {
									console.log("업데이트실패");
									}
								},error: function(e){
								
							    }
							});
						}, error: function(e) {
							console.log(e);
							alert("올바른 형식의 파일을 넣어주세요.");
						}
					});
				} 
			}, error: function(e) {
				console.log(e);
			}
		});
	});
});
				