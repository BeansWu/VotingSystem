$(function (){
	//第一次点击的时间
	var fisrtClick;
	//投票相关函数
	function voteRelated (url) {
		//时间戳
		var args = {"time" : new Date()};
		$.getJSON(url, args, function (data){
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
		})
	}
	//在加载页面时就显示候选人信息
	if ($("table").find("td").length == 0) {
		voteRelated("VoteServlet?method=getAllCandidates");
	};
	//通过 $().on() 方法，将事件绑定到新生成的节点上，否则新节点将无法触发 JQ 事件
	$("body").on("click", ".vote", function() {
		$("table").hide();
		//将原来的表格信息删除
		$("table").find("td").remove();
		//当前时间
		var now = new Date();
		
		if (fisrtClick == null) {
			//第一次点击
			fisrtClick = new Date();
			$.blockUI({ message: '<h3>投票成功，将在5秒后返回！</h3>' });
			setTimeout($.unblockUI, 5000);
			voteRelated(this.href);
		} else if((now.getTime() - fisrtClick.getTime()) <= 60000) {
			//投票间隔小于一分钟
			$.blockUI({ message: '<h3>投票失败，请在一分钟后再投票，将在5秒后返回！</h3>' });
			setTimeout($.unblockUI, 5000);
			voteRelated("VoteServlet?method=getAllCandidates");
		} else {
			//投票间隔大于一分钟，将第一次点击的时间重置
			fisrtClick = new Date();
			$.blockUI({ message: '<h3>投票成功，将在5秒后返回！</h3>' });
			setTimeout($.unblockUI, 5000);
			voteRelated(this.href);
		}
		return false;
	});
});