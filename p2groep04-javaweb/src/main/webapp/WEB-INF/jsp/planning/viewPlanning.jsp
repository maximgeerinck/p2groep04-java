<div id="calendar"></div>

<script>
    $(document).ready(function() {
        $.getJSON("/p2groep04-javaweb/planning/get.htm", function(planning) {

            var presentations = planning['presentations'];
            var eventsCustom = [];

            for (var i = 0; i < presentations.length; i++) {

                var tf = presentations[i]["timeframe"];

                var timeStart = moment(presentations[i]["date"])
                        .set('hour', tf["starttime"].split(":")[0])
                        .set('minute', tf["starttime"].split(":")[1])
                        .set('second', tf["starttime"].split(":")[2]);

                var timeEnd = moment(presentations[i]["date"])
                        .set('hour', tf["endtime"].split(":")[0])
                        .set('minute', tf["endtime"].split(":")[1])
                        .set('second', tf["endtime"].split(":")[2]);

                var event = {
                    id: presentations[i]["id"],
                    start: timeStart.format(),
                    end: timeEnd.format(),
                    title: presentations[i]["subject"]
                };
                eventsCustom.push(event);
            }


            $('#calendar').fullCalendar({
                header: {
                    left: 'prev,next today',
                    center: 'title',
                    right: 'month,agendaWeek,agendaDay'
                },
                defaultDate: moment(),
                editable: false,
                events: eventsCustom,
                weekends: false,
                timeFormat: 'H(:mm)', // uppercase H for 24-hour clock
                defaultView: 'agendaWeek',
                eventClick: function(calEvent, jsEvent, view) {
                    alert("kzet wel nen popup voor in te schrijven en zoo... DAG LOGAN");

                    // change the border color just for fun
                    //$(this).css('border-color', 'red');
                }
            });
        });
    });
</script>
