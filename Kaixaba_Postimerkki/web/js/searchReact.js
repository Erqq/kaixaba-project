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

  getInitialState(){
        return{
            data:[]
        };
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
    this.getDataFromServer('http://localhost:8080/Kaixaba_Postimerkki/SearchStamps');
    var frm = $(document.myform);
    var data = getFormData(frm);
    }





  render() {
    return (
    <div>
      <form onSubmit={this.handleSubmit} name="myform">
          Väri:<br/>
          <input type="text" name="color" defaultValue=""/>
          <br/>
          Ilmestynyt:<br/>
          <input type="text" name="releaseDate" defaultValue=""/>
          <br/>
          Poistunut:<br/>
          <input type="text" name="endDate" defaultValue=""/>
          <br/>
          Nimellisarvo:<br/>
          <input type="text" name="value" defaultValue=""/>
          <br/>
          Nimi:<br/>
          <input type="text" name="name" defaultValue=""/>
          <br/>
          Painopaikka:<br/>
          <input type="text" name="printLocation" defaultValue=""/>
          <br/>
          Painomäärä:<br/>
          <input type="text" name="printAmount" defaultValue=""/>
          <br/>
          Taiteilija:<br/>
          <input type="text" name="artist" defaultValue=""/>
          <br/>
          Valuutta:<br/>
          <input type="text" name="currency" defaultValue=""/>
          <br/>
        <input type="submit" value="Etsi" />
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
                <div className="col-xs-12"><p>Ilmestynyt:&nbsp;{camper.releaseDate}</p></div>
                <div className="col-xs-12"><p>Poistunut:&nbsp;{camper.endDate}</p></div>
                <div className="col-xs-12"><p>Väri:&nbsp;{camper.color}</p></div>
                <div className="col-xs-12"><p>Nimellisarvo:&nbsp;{camper.value}</p></div>
                <div className="col-xs-12"><p>Painopaikka:&nbsp;{camper.printLocation}</p></div>
                <div className="col-xs-12"><p>Painomäärä:&nbsp;{camper.printAmount}</p></div>
                <div className="col-xs-12"><p>Valuutta:&nbsp;{camper.currency}</p></div>
                <div className="col-xs-12"><p>Taiteilija:&nbsp;{camper.artist.length ? camper.artist : 'Ei tiedossa' }</p></div>


            </div>
            </div>
        );
        }
        return <div></div>
        
    }
});


ReactDOM.render(
            <StampForm/>,
            document.getElementById('root')
        );



