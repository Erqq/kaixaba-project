class StampForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = {value: ''};
    this.state = {data: ["asd"]}
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }


  handleChange(event) {
    this.setState({value: event.target.value});
  }

    showResult(response) {

            this.setState({
                data: response
            });
    }


  getDataFromServer(URL){
  var frm = $(document.myform);
    var data = getFormData(frm);
        $.ajax({
            type:"POST",
            dataType:"json",
            url: URL,
            data: JSON.stringify(data),
            success: function(response) {
                this.showResult(response);
            }.bind(this),
            error: function(xhr, status, err) {
                console.error(this.props.url, status, err.toString());
            }.bind(this)
        });
    }


  handleSubmit(event) {
    event.preventDefault();
    this.getDataFromServer('http://postimerkit.me:8080/Kaixaba_Postimerkki/getStamps');
    var frm = $(document.myform);
    var data = getFormData(frm);
    }





  render() {
    return (
    <div>
      <form onSubmit={this.handleSubmit} name="myform">
          <br/>
          <input type="text" name="tags" placeholder="Paina enteriä hakeaksesi..."></input>

      </form>
      
      <Result result={this.state.data}/>
      
      </div>
    );
  }
}

function getFormData($form){
    var unindexed_array = $form.serializeArray();
    var indexed_array = {};

    $.map(unindexed_array, function(n, i){
        indexed_array[n['name']] = n['value'];
    });

    return indexed_array;
}


var Result = React.createClass({
    render:function(){
        var result = this.props.result.map(function(result,index){
            return <ResultItem key={index} user={ result } />
            });
        return(
            <div className="container">
                <div className="row">
                    {result}
                </div>
            </div>
        );
    }
});

var ResultItem = React.createClass({
    render:function(){
        var camper = this.props.user;
        if (camper.releaseDate){
            return(
                <div className="col-xs-6 col-sm-4 col-md-3">
                <div className="stamp">
                <div className="col-xs-12"><h3>{camper.name}</h3></div>
                <div className="col-xs-12"><img src={camper.url} /></div>
                <div className="col-xs-12"><h4 id="otsikko">Ilmestynyt:&nbsp;</h4> <p>{camper.releaseDate}</p></div>
                <div className="col-xs-12"><h4 id="otsikko">Poistunut:&nbsp;</h4> <p>{camper.endDate ? camper.endDate : 'Ei tiedossa' }</p></div>
                <div className="col-xs-12"><h4 id="otsikko">Väri:&nbsp;</h4> <p>{camper.color ? camper.color : 'monivärinen' }</p></div>
                <div className="col-xs-12"><h4 id="otsikko">Nimellisarvo:&nbsp;</h4> <p>{camper.value}</p></div>
                <div className="col-xs-12"><h4 id="otsikko">Painopaikka:&nbsp;</h4> <p>{camper.printLocation}</p></div>
                <div className="col-xs-12"><h4 id="otsikko">Painomäärä:&nbsp;</h4> <p>{camper.printAmount}</p></div>
                <div className="col-xs-12"><h4 id="otsikko">Valuutta:&nbsp;</h4> <p>{camper.currency}</p></div>
                <div className="col-xs-12"><h4 id="otsikko">Taiteilija:&nbsp;</h4> <p>{camper.artist.length ? camper.artist : 'Ei tiedossa' }</p></div>


                </div>
                </div>
            );
        }
        return <div></div>
    }
});


ReactDOM.render(
            <StampForm/>,
            document.getElementById('app2')
        );


