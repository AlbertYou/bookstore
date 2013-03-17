function addpublisher() {
	    		apprise("增加出版社", {'input' : true}, function(publisher) {
	    			if (publisher) {
	    				var url = "haspublisher.action";
	    	    		$.ajax( {
	    	    			url : url,
	    	    			type : "POST",
	    	    			dataType : "json",
	    	    			data : {"publisher": publisher},
	    	    			success : function(data) {
	    	    				if (data.result == "exist") {
	    	    					$("#operate_result").text(publisher + "已存在");
	    	    				} else {
				    				location.href = "addpublisher.action";
	    	    				}
	    	    			}
	    	    		});
	    			}
	    		});
	        }
	    	function modifypublisher(publisherId,publisher) {
	    		apprise("修改&nbsp;" + publisher + "&nbsp;名称", {'input' : true}, function(p) {
	    			if (p) {
	    				location.href = "modifypublisher.action?publisherId=" + publisherId + "&publisher=" + p;
	    			}
	    		});
	        }
	    	function deletepublisher(t, publisherId,publisher) {
	    		var url = "deletepublisher.action";
	    		$.ajax( {
	    			url : url,
	    			type : "POST",
	    			dataType : "json",
	    			data : {"publisherId": publisherId},
	    			success : function(data) {
	    				if (data.result == "success") {
	    					$(t).parent(".delete_publisher_label").parent(".publisher_content").parent(".publisher_item").remove();
	    					$("#operate_result").text("成功删除" + publisher);
	    				} else {
	    					$("#operate_result").text("由于该出版社任有许多图书，因此不能删除");
	    				}
	    			}
	    		});
	        }