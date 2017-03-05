var MainBox  = React.createClass({
    render:function(){
        return(
            <App/>
        );
    }
});

var App = React.createClass({
    //setting up initial state
    getInitialState:function(){
        return{
            data:[]
        };
    },
    componentDidMount(){
        this.getDataFromServer('http://localhost:8080/Kaixaba_Postimerkki/getStamps');
    },
    //showResult Method
        showResult: function(response) {

            this.setState({
                data: response
            });
    },
    //making ajax call to get data from server
    getDataFromServer:function(URL){
        $.ajax({
            type:"GET",
            dataType:"json",
            url: URL,
            success: function(response) {
                this.showResult(response);
            }.bind(this),
            error: function(xhr, status, err) {
                console.error(this.props.url, status, err.toString());
            }.bind(this)
        });
    },
    render:function(){
        return(
            <div>
                <Result result={this.state.data}/>
            </div>
        );
    }
});

var Result = React.createClass({
    render:function(){
        var result = this.props.result.map(function(result,index){
            return <ResultItem key={index} user={ result } />
            });
        return(
            <div className="row">
                <div className="col-md-12">
                    <table className="table table-bordered">
                        <thead>
                            <tr>
                                <th className="col-md-4">ID</th>
                                <th>TAGS</th>
                                <th>RELEASE-DATE</th>
                                <th>END-DATE</th>
                                <th>VALUE</th>
                                <th>NAME</th>
                                <th>COLOR</th>
                                <th>PRINT LOCATION</th>
                                <th>PRINT AMOUNT</th>
                                <th>ARTIST</th>
                                <th>CURRENCY</th>
                                <th>URL</th>
                            </tr>
                        </thead>
                        <tbody>
                            {result}
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
});
var ResultItem = React.createClass({
    render:function(){
        var camper = this.props.user;
        return(
            <tr >
                <td>{camper.id}</td>
                <td>{camper.tags}</td>
                <td>{camper.releaseDate}</td>
                <td>{camper.endDate}</td>
                <td>{camper.value}</td>
                <td>{camper.name}</td>
                <td>{camper.color}</td>
                <td>{camper.printLocation}</td>
                <td>{camper.printAmount}</td>
                <td>{camper.artist}</td>
                <td>{camper.currency}</td>
                <td><img src={camper.url} /></td>
            </tr>
        );
    }
});

ReactDOM.render(<MainBox />, document.getElementById('app'));