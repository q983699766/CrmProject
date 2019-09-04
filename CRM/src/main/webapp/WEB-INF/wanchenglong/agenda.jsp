<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
    
    <head>
    <base href="<%=basePath%>">
        <title>日历页面</title>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="css/fullcalendar.css" rel="stylesheet" media="screen">
        <link href="css/styles.css" rel="stylesheet" media="screen">
        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        
            <!-- <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script> -->
       
        
        <!-- <script src="vendors/modernizr-2.6.2-respond-1.1.0.min.js"></script> -->
        <script src="js/modernizr-2.6.2-respond-1.1.0.min.js" ></script>
    </head>
    
    <body>
        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container-fluid">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> <span class="icon-bar"></span>
                     <span class="icon-bar"></span>
                     <span class="icon-bar"></span>
                    </a>
                    <a class="brand" href="#">具体日程安排</a>
                    
                </div>
            </div>
        </div>
        <div class="container-fluid">
            <div class="row-fluid">
                
                <!--/span-->
                <div class="span10" id="content">
                    <div class="row-fluid">
                        <!-- block -->
                         <div class="block">
                             <div class="navbar navbar-inner block-header">
                                <div class="muted pull-left">&nbsp;</div>
                                
                            </div>  
                            <div class="block-content collapse in">
                                <div class="span2">
                                    <div id='external-events' style="width: 130px">
                                    <h4>Draggable Events</h4>
                                    <div class='external-event'  style="background-color:rgb(194, 171, 171); ">My Event 1</div>
                                    <div class='external-event'  style="background-color:rgb(194, 171, 171); "><a class="brand" href="#">添加日程安排</a></div>
                                    
                                    <p>
                                    <input type='checkbox' id='drop-remove' /> <label for='drop-remove'>remove after drop</label>
                                    </p>
                                    </div>

                                </div>
                                
                                
                                <div class="span10">
                                    <div id='calendar'></div>
                                </div>
                                
                                
                                
                            </div>
                        </div>
                        <!-- /block -->
                    </div>
                </div>
            </div>
            <hr>
            <footer>
                <p>Copyright &copy; 2018.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
            </footer>
        </div>
        <style>
        #external-events {
            float: left;
            width: 150px;
            padding: 0 10px;
            border: 1px solid #ccc;
            background: #eee;
            text-align: left;
            }
            
        #external-events h4 {
            font-size: 16px;
            margin-top: 0;
            padding-top: 1em;
            }
            
        .external-event { /* try to mimick the look of a real event */
            margin: 10px 0;
            padding: 2px 4px;
            background: #3366CC;
            color: #fff;
            font-size: .85em;
            cursor: pointer;
            z-index: 99999999;
            }
            
        #external-events p {
            margin: 1.5em 0;
            font-size: 11px;
            color: #666;
            }
            
        #external-events p input {
            margin: 0;
            vertical-align: middle;
            }

        </style>
        <!--/.fluid-container-->
        <script src="js/jquery-1.9.1.js"></script>
        <script src="js/jquery-ui-1.10.3.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/fullcalendar.js"></script>
        <script src="js/fullcalendar/gcal.js"></script>
        <script src="js/scripts.js"></script>
        <script>
        $(function() {
            // Easy pie charts
            var calendar = $('#calendar').fullCalendar({
			header: {
				left: 'prev,next',
				center: 'title',
				right: 'month,basicWeek,basicDay'
			},
            selectable: true,
            selectHelper: true,
            select: function(start, end, allDay) {
                var title = prompt('Event Title:');
                if (title) {
                    calendar.fullCalendar('renderEvent',
                        {
                            title: title,
                            start: start,
                            end: end,
                            allDay: allDay
                        },
                        true // make the event "stick"
                    );
                }
                calendar.fullCalendar('unselect');
            },
            droppable: true, // this allows things to be dropped onto the calendar !!!
            drop: function(date, allDay) { // this function is called when something is dropped
            
                // retrieve the dropped element's stored Event Object
                var originalEventObject = $(this).data('eventObject');
                
                // we need to copy it, so that multiple events don't have a reference to the same object
                var copiedEventObject = $.extend({}, originalEventObject);
                
                // assign it the date that was reported
                copiedEventObject.start = date;
                copiedEventObject.allDay = allDay;
                
                // render the event on the calendar
                // the last `true` argument determines if the event "sticks" (http://arshaw.com/fullcalendar/docs/event_rendering/renderEvent/)
                $('#calendar').fullCalendar('renderEvent', copiedEventObject, true);
                
                // is the "remove after drop" checkbox checked?
                if ($('#drop-remove').is(':checked')) {
                    // if so, remove the element from the "Draggable Events" list
                    $(this).remove();
                }
                
            },
			editable: true,
			// US Holidays
			events: 'http://www.google.com/calendar/feeds/usa__en%40holiday.calendar.google.com/public/basic'
			
			});
        });

        $('#external-events div.external-event').each(function() {
        
            // create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
            // it doesn't need to have a start or end
            var eventObject = {
                title: $.trim($(this).text()) // use the element's text as the event title
            };
            
            // store the Event Object in the DOM element so we can get to it later
            $(this).data('eventObject', eventObject);
            
            // make the event draggable using jQuery UI
            $(this).draggable({
                zIndex: 999999999,
                revert: true,      // will cause the event to go back to its
                revertDuration: 0  //  original position after the drag
            });
            
        });
        </script>
    </body>

</html>