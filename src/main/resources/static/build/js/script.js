// All javascript code in this project for now is just for demo DON'T RELY ON IT

const random = (max = 100) => {
  return Math.round(Math.random() * max) + 20
}

const randomData = () => {
  return [
    random(),
    random(),
    random(),
    random(),
    random(),
    random(),
    random(),
    random(),
    random(),
    random(),
    random(),
    random(),
  ]
}

const months = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']

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

const barChart = new Chart(document.getElementById('barChart'), {
  type: 'bar',
  data: {
    labels: months,
    datasets: [
      {
        data: randomData(),
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
          maxBarThickness: '10',
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

// address 지갑주소 연동
$(document).ready(function(){
	$("#adr_button").click(function(event){
		//event.preventDefault();
		var user_adr = $("#user_adr");
		console.log(user_adr);
		
		$.ajax({
	        url : 'http://127.0.0.1:5000/user_adr',
	        async : true,
	        type : 'get',
	        data : user_adr,
	        dataType:'json',
			success : function(res){
				console.log(res);
				
			},error : function(e){
				console.log(e);
				alert("올바른 형식의 파일을 넣어주세요.");
			}
	    });
	});
});

// csv 첨부파일 연동
$(document).ready(function(){
	$("#csv_button").click(function(event){
		//event.preventDefault();
		var user_csv_form = $("#user_csv_form")[0];
		var csv_form = new FormData(user_csv_form);
		
		$.ajax({
	        url : 'http://127.0.0.1:5000/user_csv',
	        async : true,
	        type : 'post',
	        data : csv_form,
	        dataType:'json',
	        cache: false,
	        contentType : false,
	        processData : false,
			success : function(res){
				console.log(res);
				const normal = [];
				const abnormal = [];
				for(let i = 0; i < res.length; i++){
					if(res[i]=="0"){
						normal.push("0");
					}else if(res[i]=="1"){
						abnormal.push("1");
					}
				}
				
				const doughnutChart = new Chart(document.getElementById('doughnutChart'), {
					  type: 'doughnut',
					  data: {
					    labels: ['normal', 'abnormal'],
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
				
			},error : function(e){
				console.log(e);
				alert("올바른 형식의 파일을 넣어주세요.");
			}
	    });
	});
});

const activeUsersChart = new Chart(document.getElementById('activeUsersChart'), {
  type: 'bar',
  data: {
    labels: [...randomData(), ...randomData()],
    datasets: [
      {
        data: [...randomData(), ...randomData()],
        backgroundColor: colors.primary,
        borderWidth: 0,
        categoryPercentage: 1,
      },
    ],
  },
  options: {
    scales: {
      yAxes: [
        {
          display: false,
          gridLines: false,
        },
      ],
      xAxes: [
        {
          display: false,
          gridLines: false,
        },
      ],
      ticks: {
        padding: 10,
      },
    },
    cornerRadius: 2,
    maintainAspectRatio: false,
    legend: {
      display: false,
    },
    tooltips: {
      prefix: 'Users',
      bodySpacing: 4,
      footerSpacing: 4,
      hasIndicator: true,
      mode: 'index',
      intersect: true,
    },
    hover: {
      mode: 'nearest',
      intersect: true,
    },
  },
})

const lineChart = new Chart(document.getElementById('lineChart'), {
  type: 'line',
  data: {
    labels: months,
    datasets: [
      {
        data: randomData(),
        fill: false,
        borderColor: colors.primary,
        borderWidth: 2,
        pointRadius: 0,
        pointHoverRadius: 0,
      },
    ],
  },
  options: {
    responsive: true,
    scales: {
      yAxes: [
        {
          gridLines: false,
          ticks: {
            beginAtZero: false,
            stepSize: 50,
            fontSize: 12,
            fontColor: '#97a4af',
            fontFamily: 'Open Sans, sans-serif',
            padding: 20,
          },
        },
      ],
      xAxes: [
        {
          gridLines: false,
        },
      ],
    },
    maintainAspectRatio: false,
    legend: {
      display: false,
    },
    tooltips: {
      hasIndicator: true,
      intersect: false,
    },
  },
})

let randomUserCount = 0

const usersCount = document.getElementById('usersCount')

const fakeUsersCount = () => {
  randomUserCount = random()
  activeUsersChart.data.datasets[0].data.push(randomUserCount)
  activeUsersChart.data.datasets[0].data.splice(0, 1)
  activeUsersChart.update()
  usersCount.innerText = randomUserCount
}

setInterval(() => {
  fakeUsersCount()
}, 1000)
