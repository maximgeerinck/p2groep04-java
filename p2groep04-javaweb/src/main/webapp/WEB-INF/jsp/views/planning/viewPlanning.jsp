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
                    
                    <!-- message voor als men inschrijven klikt -->
                    <div class="alert" id="inschrijven-melding" style="display:none;"></div>
                    
                    <!-- progressbar -->
                    <div class="progress progress-striped active" id="progressbar-amount">
                        <div class="progress-bar" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100">
                            <span id="amount_subscribed"></span>/<span id="amount_capacity"></span>                                                        
                        </div>
                    </div>
                    
                    <table class="table table-planning">
                        <tr>
                            <th>Title:</th>
                            <td><span id="titel"></span></td>
                        </tr>
                        <tr>
                            <th>Presentator:</th>
                            <td> <span id="naam"></span></td>
                        </tr>
                        <tr>
                            <th style="width:176px;">Onderzoeksdomeinen: </th>
                            <td><span id="researchdomains"></span></td>
                        </tr>  
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" id="btnInschrijven" data-val="" class="btn btn-primary">Inschrijven</button>
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
            console.log(presentations.length);
            
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
                    key: i,
                    id: presentations[i]["id"],
                    start: timeStart.format(),
                    end: timeEnd.format(),
                    title: presentations[i]["subject"]
                };
                eventsCustom.push(event);
            }
            
            console.log(eventsCustom);


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
                    $('#amount_subscribed').text(planning['presentations'][calEvent.key].subscribers);
                    $('#amount_capacity').text(planning['presentations'][calEvent.key].capacity);
                    $('#progressbar-amount .progress-bar').css('width', (planning['presentations'][calEvent.key].subscribers / planning['presentations'][calEvent.key].capacity * 100) + '%');
                    
                    $('#naam').text(planning['presentations'][calEvent.key].presentator);
                    $('#myModalLabel').text(planning['presentations'][calEvent.key].subject);
                    $('#titel').text(planning['presentations'][calEvent.key].subject);
                    
                    var rds = planning['presentations'][calEvent.key]["researchDomains"].map(function(elem){
                                  return '<span class="tag">' + elem.name + '</span>';
                              }).join("");
                    
                    console.log(planning['presentations'][calEvent.key]["researchDomains"]);
                    $('#researchdomains').html(rds);
                    
                    $('#modal-event').modal('show');
                }
            });
        });
        
        //inschrijven
        //data-val in btnInschrijven bevat presentatie id
        $('#btnInschrijven').click(function(event) {
            
            var im = $('#inschrijven-melding')
            $.post('/p2groep04-javaweb/presentatie/inschrijven', {id: $(this).attr('data-val')})
                .done(function(data) {
                    var data = JSON.parse(data);
            
                    im.text((data["success"] == true) ? "U werd succesvol ingeschreven voor deze presentatie" : data["message"]);
                    im.slideDown();
                    im.attr("class", (data["success"] == true) ? "alert alert-success" : "alert alert-error");
                });
            })
        });
    });
</script>
