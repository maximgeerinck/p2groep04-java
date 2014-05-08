<section id="dashboard" class="pane">
    <div id="calendar"></div>

    <!-- Modal -->
    <div class="modal fade" id="modal-event" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                </div>
                <div class="modal-body">
                    <!-- progressbar -->
                    <div class="progress progress-striped active" id="progressbar-amount">
                        <div class="progress-bar" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100">
                            <span id="amount_subscribed"></span>/<span id="amount_capacity"></span>
                            
                            
                        </div>
                    </div>
                    
                    <span id="titel"></span>
                    <span id="researchdomains"></span>
                    <span id="naam"></span>
                    
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" id="btnInschrijven" class="btn btn-primary">Inschrijven</button>
                </div>
            </div>
        </div>
    </div>

</section>
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
                    // get details
                    $('#amount_subscribed').text(planning['presentations'][calEvent.id].subscribers);
                    $('#amount_capacity').text(planning['presentations'][calEvent.id].capacity);
                    $('#progressbar-amount .progress-bar').css('width', (planning['presentations'][calEvent.id].subscribers / planning['presentations'][calEvent.id].capacity * 100) + '%');
                    
                    $('#naam').text(planning['presentations'][calEvent.id].presentator);
                    $('#titel').text(planning['presentations'][calEvent.id].subject);
                    
                    //array overlopen
                    var rds = [];
                    for(var j = 0; j < planning['presentations'][calEvent.id].researchDomains.length; i++) {
                        rds.put(planning['presentations'][calEvent.id].researchDomains[j].name);
                    }
                    $('#researchdomains').text(rds.join());
                    
                    $('#modal-event').modal('show');
                }
            });
        });
    });
</script>
