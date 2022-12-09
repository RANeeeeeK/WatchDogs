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


// 사용자 csv 첨부파일 연동 : 도넛,막대,관계그래프
$(document).ready(function() {
	$("#csv_button").click(function(event) {
		//event.preventDefault();
		var user_csv_form = $("#user_csv_form")[0];
		var csv_form = new FormData(user_csv_form);

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

				// 사용횟수 업데이트, 조회
				$.ajax({
					url: 'use_cnt',
					type: 'post',
					contentType: "application/json; charset=utf-8",
					data: {user_id : `${vo.getUser_id()}`
					},
					success: function(res) {
						console.log(res);
						

					}, error: function(e) {
						console.log(e);
						alert("조회 실패");
					}
				});

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

			}, error: function(e) {
				console.log(e);
				alert("올바른 형식의 파일을 넣어주세요.");
			}
		});

	});
});