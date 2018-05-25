
//Fichier d'inscription

var form = document.getElementById("hidden");

var fin = document.getElementById("fin");

var option = document.getElementsByName("quality");


//On crée ici les grades
var select = document.createElement("select");
var label = document.createElement("label");
var labelText = document.createTextNode("Grade");
label.appendChild(labelText);
label.className = "grade-text";

select.className = "grade form-control";
select.setAttribute("name","grade");

var grades=[];
var gradesValues=["Assistant", "CC", "MC", "PR"];
var gradesText = ["Assistant", "CC", "MC", "PR"];
//console.log('Bienvenue');
 for (var i = 0; i < 4; i++) {
 	grades[i] =  document.createElement("option");
 	grades[i].setAttribute("value", gradesValues[i]);
 	grades[i].appendChild(document.createTextNode(gradesText[i]));
 	select.appendChild(grades[i]);
 }


//Ici on crée les niveaux
var select1 = document.createElement("select");
var label1 = document.createElement("label");
var label1Text = document.createTextNode("Niveau");
label1.appendChild(label1Text);
label1.className = "niveau-text";

select1.className = "niveau form-control";
select1.setAttribute("name","level");

var levels=[];
var levelsValues=["M1", "M2", "D1", "D2","D3"];
var levelsText = ["M1", "M2", "D1", "D2","D3"];
console.log('Bienvenue');
 for (var i = 0; i < 5; i++) {
 	levels[i] =  document.createElement("option");
 	levels[i].setAttribute("value", levelsValues[i]);
 	levels[i].appendChild(document.createTextNode(levelsText[i]));
 	select1.appendChild(levels[i]);
 }


 //form.insertBefore(fin, select);
 form.appendChild(label);
form.appendChild(select);
form.appendChild(label1);
form.appendChild(select1);

label1.style.display = 'none';
select1.style.display = 'none';
//select.style.display = 'none';
//label.style.display = 'none';


function chooseGrade () {
	var niveauText = document.querySelector(".niveau-text");
	niveauText.style.display = 'none';
	var gradeText = document.querySelector(".grade-text");
	gradeText.style.display = 'block';
	var niveau = document.querySelector(".niveau");
	niveau.style.display = 'none';
	var grade = document.querySelector(".grade");
	grade.style.display = 'block';
	
	//console.log('Bienvenue');

	
}

function chooseLevel () {
	var niveauText = document.querySelector(".niveau-text");
	niveauText.style.display = 'block';
	var gradeText = document.querySelector(".grade-text");
	gradeText.style.display = 'none';
	var grade = document.querySelector(".grade");
	grade.style.display = 'none';
	var niveau = document.querySelector(".niveau");
	niveau.style.display = 'block';
	console.log('Bienvenue cl');
	
}