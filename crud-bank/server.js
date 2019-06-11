const express = require('express');
const bodyParser = require('body-parser')
const app = express();

app.use(bodyParser.urlencoded({ extended: true }));
const MongoClient = require('mongodb').MongoClient
const uri = "mongodb://root:123@172.23.0.3:27017"

MongoClient.connect(uri, (err, client) => {
    if (err) {
        return console.log(err);
    }

    db = client.db(`local`);
})

app.listen(3600, function () {
    console.log('Serving running port 3600')
});

app.get('/', (req, res) => {
    let cursor = db.collection('data').find();
    res.send(cursor.toArray())
});

app.post('/', (req, res) => {
    console.log("copo", req)
    db.collection('data').insertOne(req.body, (err, result) => {
        if (err) return console.log(err)

        db.collection(`data`).find().toArray((err, results) => {
            res.send(results)

        });

    });
});

app.route('/edit/:id').get((req, res) => {
    var id = req.params.id;
    var name = req.body.name;

    db.collection('data').updateOne({ _id: ObjectId(id) }, {
        $set: {
            name: name
        }
    }, (err, result) => {
        if (err) return res.send(err);

        console.log("dados atualizados")
        res.send("dados atualizados")
    })
})

app.route('/edit/:id').get((req, res) => {
    var id = req.params.id;

    db.collection('data').deleteOne({ _id: ObjectId(id) }, (err, result) => {
        if (err) return res.send(500, err);
        console.log("Deletado")
        res.send("Deletado")
    })
})
