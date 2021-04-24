
var express = require("express");

var app = express();

app.use(express.json());


app.use(express.urlencoded({extended:true}));

var userList = ["Jhon",
"Luis",
"Morgona",
"Julia",
"Orlean",
"Memmi",
"Varden",
"Morgan",
"Tom",
"Tomy",
"Jesccia",
"Koran",
"Marta",
"Moris",
"Luis",
"Luana",
"Barbara",
"Guarden", 
"Tonber",
"Raul",
"Ronald",
"Drogba",
"Paul",
"Pristen",
"Kaule",
"Anna",
"Jhonsen",
"Petra",
"Bob",
"Valden",
"Ponter",
"Kuliss",
"Verra",
"Larden",
"Venya",
"Broden",
"Maspop",
"Clover",
"Kenna",
"Taniya",
"Steven",
"Julia",
"Juli",
"Angelia",
"Staloni",
"Katena",
"Shurdan",
"Lavender",
"Ella",
"Jsckson",
"Jack",
"Avery",
"Madison",
"Wyatt",
"Stuin",
"Karl",
"Karlston",
"Tonyy",
"Carter",
"Hazel",
"Lily",
"Ellie",
"Jaxon",
"Aubrey",
"Addison",
];

var PORT = process.env.PORT || 3000;


app.get("/users", (req, res,) => {
    res.json(userList);
   });

app.listen(PORT,function(req,res){

    console.log("Server running on port 3000");

});
