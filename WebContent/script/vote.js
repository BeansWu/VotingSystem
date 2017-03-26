$(function (){
	//从 JSON 返回的数据中提取信息并新建节点，然后添加到 table 下
	function addNodes (data) {
		for (var i = 0; i < data.length; i++) {
			//获取信息
			var id = data[i].id;
			var name = data[i].name;
			var vote = data[i].vote;
			//新建节点并添加到表格中
			$("table").append("<tr><td>" + id + "</td><td>" + name + "</td>" +
					"<td><div class='progress'>" +
					"<div class='progress-bar progress-bar-info' role='progressbar'aria-valuenow=" + vote * 10 + " aria-valuemin='0' aria-valuemax='100'style='min-width: 2em ;width: " + vote + "%;'>" + vote + "</div>" +
					"</div></td>" + 
					"<td><a class='vote' href='VoteServlet?method=vote&id=" + id + "'>投票</a></td>" + 
					"</tr>")
		}
		//显示表格
		$("table").show();
	}
	//在加载页面时就显示候选人信息
	if ($("table").find("td").length == 0) {
		var url = "VoteServlet?method=getAllCandidates";
		//时间戳
		var args = {"time" : new Date()};
		$.getJSON(url, args, function (data){
			addNodes (data);
		})
	};
	//通过 $().on() 方法，将事件绑定到新生成的节点上，否则新节点将无法触发 JQ 事件
	$("body").on("click", ".vote", function() {
		var url = this.href;
		var args = {"time" : new Date()};
		$.getJSON(url, args, function (data){
			if (data == "Time limit.") {
				//时间小于一分钟
				$.blockUI({ message: '<h3>投票失败，请在一分钟后再投票，将在5秒后返回！</h3>' });
				setTimeout($.unblockUI, 5000);
			} else {
				$.blockUI({ message: '<h3>投票成功，将在5秒后返回！</h3>' });
				setTimeout($.unblockUI, 5000);
				//隐藏表格
				$("table").hide();
				//删除过时的节点信息
				$("table").find("td").remove();
				addNodes (data);
				//显示表格
				$("table").show();
			}
		})
		return false;
	});
});