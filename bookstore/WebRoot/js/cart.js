function changequantity(a, productId) {
        		var quantity = $(a).prev(":text").val();
        		var stock = $(a).prevUntil(":hidden").val();
        		if(quantity > stock) {
 	        		$(a).parent(".modifyquantity_form").next(".modifyquantity_result").children(".notice_label").text("库存不足,目前库存为" + stock);
 	        		return false;
        		}
        		var url = "changequantity.action";
            	$.ajax({
                	url: url,
                	type: "POST",
                	dataType: "json",
                	data: {"quantity": quantity, "productId": productId},
                	success: function(json) {
    	        		if(json.stock != null) {
    	        			$(a).parent(".modifyquantity_form").next(".modifyquantity_result").children(".notice_label").text("库存不足,目前库存为" + json.stock);
    	        		} else {
    	        			$(a).parent(".modifyquantity_form").next(".modifyquantity_result").children(".notice_label").text("修改成功");
    	        		}
            		}
            	});
    		}
    		$(function() {
        		$("#countorder_button").click(function() {
            		var flag = 0;
            		$(".modifyquantity_form").each(function() {
                		var stock = $(this).children(".stock").val();
                		var quantity = $(this).children(".quantity").val();
                		if(new Number(quantity) > new Number(stock)) {
                    		$(this).next(".modifyquantity_result").children(".notice_label").text("库存不足,目前库存为" + stock);
                    		flag = 1;
                		}
            		});
            		if(flag == 0) {
	           			location.href="confirmorder.action";
            		}            		
           		});
    		});