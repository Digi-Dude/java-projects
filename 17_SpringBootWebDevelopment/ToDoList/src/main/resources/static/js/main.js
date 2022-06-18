$(document).ready(function($) {



    // Add do in list
    const appendDo = function(data){
        var code = '<a href="#" class="do-link" data-id="' + data.id + '">' + 
        '<h2 class="name">' + data.name +
        '</h2><p class="date">' + data.date +
        '</p><p class="description">' + data.description +
        '</p></a>';

        $('#list').prepend('<div class="do">' + '<a href="#" class="remove"><</a>' + code + '</div>');
    };


//    //Loading doings on load page
//    $.get('/doings/', function(response){
//        for(i in response) {
//            appendDo(response[i]);
//        }
//    });

    // Open popup description
    $('.do-link').click(function() {
        var desc = $(this).find('.description').text();
        $('#popup-desc .popup').append('<p>' + desc + '</p>');
        $('#popup-desc').show();
        return false
    });


    // Open popup form
    $('#add-do-button').click(function() {
        $('#popup-do').show();
        return false
    });


	// Click on link "Close".
	$('.popup-close').click(function() {
		$('.popup-fade').fadeOut();
		return false;
	});

	// Close by key Esc.
	$(document).keydown(function(e) {
		if (e.keyCode === 27) {
			e.stopPropagation();
			$('.popup-fade').fadeOut();
            $('#popup-desc p').remove();
		}
	});

	// Click on bg
	$('.popup-fade').click(function(e) {
		if ($(e.target).closest('.popup').length == 0) {
			$(this).fadeOut();
            $('#popup-desc p').remove();
		}
	});


    // Add do
    $('#add-do').click(function()
    {
        var data = $('#popup-do form').serialize();
        $.ajax({
            method: "POST",
            url: '/doings/',
            data: data,
            success: function(response)
            {
                $('.popup-fade').fadeOut();
                var newDo = {};
                newDo.id = response;
                var dataArray = $('#popup-do form').serializeArray();
                for(i in dataArray) {
                    newDo[dataArray[i]['name']] = dataArray[i]['value'];
                }

                appendDo(newDo);
            },
            error: function(response) {
                $('.popup-fade').fadeOut();
                alert(response);
            }

        });
        return false;
    });


    $(document).on('click', '.do-link', function() {
        var link = $(this); 
        var id  = link.data('id');
        $.ajax({
            method: 'GET',
            url: '/doings/' + id,
            success: function(response) {
                var desc = response;
    
                $('#popup-desc .popup').append('<p>' + desc.description + '</p>');
                $('#popup-desc').show();
            },
            error: function(response) {
                console.log(response);
                alert('data not found');
              }
        })
        return false;
    })

    $(document).on('click', '.remove', function() {
        var linkRemove = $(this);
        var doDiv = linkRemove.parent();
        var id = doDiv.find('.do-link').data('id');
        console.log(id);
        $.ajax({
            method: 'DELETE',
            url: '/doings/' + id,
            success: function() {
                doDiv.remove();
            },
            error: function(response) {
                alert('data not found');
            }
        })
    })

});