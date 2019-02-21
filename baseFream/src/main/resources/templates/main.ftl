<!-- widget grid -->
<section id="widget-grid" class="">

    <!-- end row -->

    <!-- row -->

    <div class="row">

        <article class=" col-lg-11">


            <!-- end widget -->

            <!-- new widget -->
            <div class="jarviswidget jarviswidget-color-blueDark" id="wid-id-3" data-widget-colorbutton="false">
                <header>
                    <span class="widget-icon"> <i class="fa fa-calendar"></i> </span>
                    <h2> 工作日历 </h2>
                    <div class="widget-toolbar">
                        <!-- add: non-hidden - to disable auto hide -->
                        <div class="btn-group">
                            <button class="btn dropdown-toggle btn-xs btn-default" data-toggle="dropdown">
                                Showing <i class="fa fa-caret-down"></i>
                            </button>
                            <ul class="dropdown-menu js-status-update pull-right">
                                <li>
                                    <a href="javascript:void(0);" id="mt">Month</a>
                                </li>
                                <li>
                                    <a href="javascript:void(0);" id="ag">Agenda</a>
                                </li>
                                <li>
                                    <a href="javascript:void(0);" id="td">Today</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </header>

                <!-- widget div-->
                <div>
                    <!-- widget edit box -->
                    <div class="jarviswidget-editbox">

                        <input class="form-control" type="text">

                    </div>
                    <!-- end widget edit box -->

                    <div class="widget-body no-padding">
                        <!-- content goes here -->
                        <div class="widget-body-toolbar">

                            <div id="calendar-buttons">

                                <div class="btn-group">
                                    <a href="javascript:void(0)" class="btn btn-default btn-xs" id="btn-prev"><i class="fa fa-chevron-left"></i></a>
                                    <a href="javascript:void(0)" class="btn btn-default btn-xs" id="btn-next"><i class="fa fa-chevron-right"></i></a>
                                </div>
                            </div>
                        </div>
                        <div id="calendar"></div>

                        <!-- end content -->
                    </div>

                </div>
                <!-- end widget div -->
            </div>
            <!-- end widget -->

        </article>
    </div>

    <!-- end row -->

</section>
<!-- end widget grid -->

<script type="text/javascript">
    /* DO NOT REMOVE : GLOBAL FUNCTIONS!
     *
     * pageSetUp(); WILL CALL THE FOLLOWING FUNCTIONS
     *
     * // activate tooltips
     * $("[rel=tooltip]").tooltip();
     *
     * // activate popovers
     * $("[rel=popover]").popover();
     *
     * // activate popovers with hover states
     * $("[rel=popover-hover]").popover({ trigger: "hover" });
     *
     * // activate inline charts
     * runAllCharts();
     *
     * // setup widgets
     * setup_widgets_desktop();
     *
     * // run form elements
     * runAllForms();
     *
     ********************************
     *
     * pageSetUp() is needed whenever you load a page.
     * It initializes and checks for all basic elements of the page
     * and makes rendering easier.
     *
     */

    var   flot_multigraph, calendar;

    pageSetUp();

    /*
     * PAGE RELATED SCRIPTS
     */

    // pagefunction

    var pagefunction = function() {

        $(".js-status-update a").click(function () {
            var selText = $(this).text();
            var $this = $(this);
            $this.parents('.btn-group').find('.dropdown-toggle').html(selText + ' <span class="caret"></span>');
            $this.parents('.dropdown-menu').find('li').removeClass('active');
            $this.parent().addClass('active');
        });

        /*
         * TODO: add a way to add more todo's to list
         */

        // initialize sortable





        // count tasks
        /*function countTasks() {

            $('.todo-group-title').each(function () {
                var $this = $(this);
                $this.find(".num-of-tasks").text($this.next().find("li").size());
            });

        }*/

        /*
         * RUN PAGE GRAPHS
         */

        // load all flot plugins
        loadScript("js/plugin/flot/jquery.flot.cust.min.js", function(){
            loadScript("js/plugin/flot/jquery.flot.resize.min.js", function(){
                loadScript("js/plugin/flot/jquery.flot.time.min.js", function(){
                    loadScript("js/plugin/flot/jquery.flot.tooltip.min.js", generatePageGraphs);
                });
            });
        });


        function generatePageGraphs() {

            /* TAB 1: UPDATING CHART */
            // For the demo we use generated data, but normally it would be coming from the server

            var data = [],
                totalPoints = 200;

            function getRandomData() {
                if (data.length > 0)
                    data = data.slice(1);

                // do a random walk
                while (data.length < totalPoints) {
                    var prev = data.length > 0 ? data[data.length - 1] : 50;
                    var y = prev + Math.random() * 10 - 5;
                    if (y < 0)
                        y = 0;
                    if (y > 100)
                        y = 100;
                    data.push(y);
                }

                // zip the generated y values with the x values
                var res = [];
                for (var i = 0; i < data.length; ++i)
                    res.push([i, data[i]])
                return res;
            }

            // setup control widget
            var updateInterval = 1500;


            /* live switch */
            $('input[type="checkbox"]#start_interval').click(function () {
                if ($(this).prop('checked')) {
                    $on = true;
                    updateInterval = 1500;
                    update();
                } else {
                    clearInterval(updateInterval);
                    $on = false;
                }
            });

            function update() {

                try {
                    if ($on == true) {

                        setTimeout(update, updateInterval);

                    } else {
                        clearInterval(updateInterval)
                    }
                }
                catch(err) {
                    clearInterval(updateInterval);
                }

            }

            var $on = false;

            $(function () {

                var trgt = [
                        [1354586000000, 153],
                        [1364587000000, 658],
                        [1374588000000, 198],
                        [1384589000000, 663],
                        [1394590000000, 801],
                        [1404591000000, 1080],
                        [1414592000000, 353],
                        [1424593000000, 749],
                        [1434594000000, 523],
                        [1444595000000, 258],
                        [1454596000000, 688],
                        [1464597000000, 364]
                    ],
                    prft = [
                        [1354586000000, 53],
                        [1364587000000, 65],
                        [1374588000000, 98],
                        [1384589000000, 83],
                        [1394590000000, 980],
                        [1404591000000, 808],
                        [1414592000000, 720],
                        [1424593000000, 674],
                        [1434594000000, 23],
                        [1444595000000, 79],
                        [1454596000000, 88],
                        [1464597000000, 36]
                    ],
                    sgnups = [
                        [1354586000000, 647],
                        [1364587000000, 435],
                        [1374588000000, 784],
                        [1384589000000, 346],
                        [1394590000000, 487],
                        [1404591000000, 463],
                        [1414592000000, 479],
                        [1424593000000, 236],
                        [1434594000000, 843],
                        [1444595000000, 657],
                        [1454596000000, 241],
                        [1464597000000, 341]
                    ],
                    toggles = $("#rev-toggles"),
                    target = $("#flotcontainer");

                var data = [{
                    label: "Target Profit",
                    data: trgt,
                    bars: {
                        show: true,
                        align: "center",
                        barWidth: 30 * 30 * 60 * 1000 * 80
                    }
                }, {
                    label: "Actual Profit",
                    data: prft,
                    color: '#3276B1',
                    lines: {
                        show: true,
                        lineWidth: 3
                    },
                    points: {
                        show: true
                    }
                }, {
                    label: "Actual Signups",
                    data: sgnups,
                    color: '#71843F',
                    lines: {
                        show: true,
                        lineWidth: 1
                    },
                    points: {
                        show: true
                    }
                }]

                var options = {
                    grid: {
                        hoverable: true
                    },
                    tooltip: true,
                    tooltipOpts: {
                        //content: '%x - %y',
                        //dateFormat: '%b %y',
                        defaultTheme: false
                    },
                    xaxis: {
                        mode: "time"
                    },
                    yaxes: {
                        tickFormatter: function (val, axis) {
                            return "$" + val;
                        },
                        max: 1200
                    }

                };

                flot_multigraph = null;

                function plotNow() {
                    var d = [];
                    toggles.find(':checkbox').each(function () {
                        if ($(this).is(':checked')) {
                            d.push(data[$(this).attr("name").substr(4, 1)]);
                        }
                    });
                    if (d.length > 0) {
                        if (flot_multigraph) {
                            flot_multigraph.setData(d);
                            flot_multigraph.draw();
                        } else {
                            flot_multigraph = $.plot(target, d, options);
                        }
                    }

                };

                toggles.find(':checkbox').on('change', function () {
                    plotNow();
                });

                plotNow()

            });

        }

        /*
         * VECTOR MAP
         */

        data_array = {
            "US": 4977,
            "AU": 4873,
            "IN": 3671,
            "BR": 2476,
            "TR": 1476,
            "CN": 146,
            "CA": 134,
            "BD": 100
        };

        // Load Map dependency 1 then call for dependency 2 and then run renderVectorMap function
        loadScript("js/plugin/vectormap/jquery-jvectormap-1.2.2.min.js", function(){
            loadScript("js/plugin/vectormap/jquery-jvectormap-world-mill-en.js", renderVectorMap);
        });


        function renderVectorMap() {
            $('#vector-map').vectorMap({
                map: 'world_mill_en',
                backgroundColor: '#fff',
                regionStyle: {
                    initial: {
                        fill: '#c4c4c4'
                    },
                    hover: {
                        "fill-opacity": 1
                    }
                },
                series: {
                    regions: [{
                        values: data_array,
                        scale: ['#85a8b6', '#4d7686'],
                        normalizeFunction: 'polynomial'
                    }]
                },
                onRegionLabelShow: function (e, el, code) {
                    if (typeof data_array[code] == 'undefined') {
                        e.preventDefault();
                    } else {
                        var countrylbl = data_array[code];
                        el.html(el.html() + ': ' + countrylbl + ' visits');
                    }
                }
            });
        }

        /*
         * FULL CALENDAR JS
         */

        // Load Calendar dependency then setup calendar

        loadScript("js/plugin/moment/moment.min.js", function(){
            loadScript("js/plugin/fullcalendar/jquery.fullcalendar.min.js", setupCalendar);
        });

        function setupCalendar() {

            if ($("#calendar").length) {
                var date = new Date();
                var d = date.getDate();
                var m = date.getMonth();
                var y = date.getFullYear();

                calendar = $('#calendar').fullCalendar({

                    editable: false,  //修改此属性，可以是否拖动
                    draggable: true,
                    selectable: false,
                    selectHelper: true,
                    unselectAuto: false,
                    disableResizing: false,

                    header: {
                        left: 'title', //,today
                        center: 'prev, next, today',
                        right: 'month, agendaWeek, agenDay' //month, agendaDay,
                    },

                    select: function (start, end, allDay) {
                        var title = prompt('Event Title:');
                        if (title) {
                            calendar.fullCalendar('renderEvent', {
                                    title: title,
                                    start: start,
                                    end: end,
                                    allDay: allDay
                                }, true // make the event "stick"
                            );
                        }
                        calendar.fullCalendar('unselect');
                    },

                    events: [{
                        title: 'All Day Event',
                        start: new Date(y, m, 1),
                        description: 'long description',
                        className: ["event", "bg-color-greenLight"],
                        icon: 'fa-check'
                    }, {
                        title: 'Long Event',
                        //start: new Date(y, m, d - 5),
                        start: new Date(y, m, d - 5),
                        end: new Date(y, m, d - 2),
                        className: ["event", "bg-color-red"],
                        icon: 'fa-lock'
                    }, {
                        id: 999,
                        title: 'Repeating Event',
                        start: new Date(y, m, d - 3, 16, 0),
                        allDay: false,
                        className: ["event", "bg-color-blue"],
                        icon: 'fa-clock-o'
                    }, {
                        id: 999,
                        title: 'Repeating Event1',
                        start: new Date(y, m, d + 4, 16, 0),
                        allDay: false,
                        className: ["event", "bg-color-blue"],
                        icon: 'fa-clock-o'
                    }, {
                        title: 'Meeting',
                        start: new Date(y, m, d, 10, 30),
                        allDay: false,
                        className: ["event", "bg-color-darken"]
                    }, {
                        title: 'Lunch',
                        start: new Date(y, m, d, 12, 0),
                        end: new Date(y, m, d, 14, 0),
                        allDay: false,
                        className: ["event", "bg-color-darken"]
                    }, {
                        title: 'Birthday Party',
                        start: new Date(y, m, d + 1, 19, 0),
                        end: new Date(y, m, d + 1, 22, 30),
                        allDay: false,
                        className: ["event", "bg-color-darken"]
                    }, {
                        title: 'Smartadmin Open Day',
                        start: new Date(y, m, 28),
                        end: new Date(y, m, 29),
                        className: ["event", "bg-color-darken"]
                    }],

                    eventRender: function (event, element, icon) {
                        if (!event.description == "") {
                            element.find('.fc-event-title').append("<br/><span class='ultra-light'>" + event.description +
                                "</span>");
                        }
                        if (!event.icon == "") {
                            element.find('.fc-event-title').append("<i class='air air-top-right fa " + event.icon +
                                " '></i>");
                        }
                    }
                });

            };

            /* hide default buttons */
            $('.fc-header-right, .fc-header-center').hide();

        }

        // calendar prev
        $('#calendar-buttons #btn-prev').click(function () {
            $('.fc-button-prev').click();
            return false;
        });

        // calendar next
        $('#calendar-buttons #btn-next').click(function () {
            $('.fc-button-next').click();
            return false;
        });

        // calendar today
        $('#calendar-buttons #btn-today').click(function () {
            $('.fc-button-today').click();
            return false;
        });

        // calendar month
        $('#mt').click(function () {
            $('#calendar').fullCalendar('changeView', 'month');
        });

        // calendar agenda week
        $('#ag').click(function () {
            $('#calendar').fullCalendar('changeView', 'agendaWeek');
        });

        // calendar agenda day
        $('#td').click(function () {
            $('#calendar').fullCalendar('changeView', 'agendaDay');
        });

        /*
         * CHAT
         */

        var filter_input = $('#filter-chat-list'),
            chat_users_container = $('#chat-container > .chat-list-body'),
            chat_users = $('#chat-users'),
            chat_list_btn = $('#chat-container > .chat-list-open-close');
            //chat_body = $('#chat-body');

        /*
         * LIST FILTER (CHAT)
         */

        // custom css expression for a case-insensitive contains()
        jQuery.expr[':'].Contains = function (a, i, m) {
            return (a.textContent || a.innerText || "").toUpperCase().indexOf(m[3].toUpperCase()) >= 0;
        };

        function listFilter(list) {
            // header is any element, list is an unordered list
            // create and add the filter form to the header

            filter_input.change(function () {
                var filter = $(this).val();
                if (filter) {
                    // this finds all links in a list that contain the input,
                    // and hide the ones not containing the input while showing the ones that do
                    chat_users.find("a:not(:Contains(" + filter + "))").parent().slideUp();
                    chat_users.find("a:Contains(" + filter + ")").parent().slideDown();
                } else {
                    chat_users.find("li").slideDown();
                }
                return false;
            }).keyup(function () {
                // fire the above change event after every letter
                $(this).change();

            });

        }

        // on dom ready
        listFilter(chat_users);

        // open chat list
        chat_list_btn.click(function () {
            $(this).parent('#chat-container').toggleClass('open');
        })

       /* chat_body.animate({
            scrollTop: chat_body[0].scrollHeight
        }, 500);*/

    };


    pagefunction();


</script>
