/**
 * 
 */

document.addEventListener("DOMContentLoaded", function() {
	var goalsHost = document.getElementById("goalsHost");
	var goalsGuest = document.getElementById("goalsGuest");
	var formGameGoalsHost = document.getElementById("formGameGoalsHost");
	var formGameGoalsGuest = document.getElementById("formGameGoalsGuest");
	
	var randomPenalty = document.getElementById("randomPenalty");
	var calculatePenalty = document.getElementById("calculatePenalty");
	var randomScore = document.getElementById("randomScore");
	var finishGame = document.getElementById("finishGame");
	
	var comment = document.getElementById("comment");
	
	randomScore.addEventListener("click", function() {
		goalsHost.style.color = "blue";
		var goalsHostNo = Math.floor(Math.random()*10)
		goalsHost.innerText = goalsHostNo;
		goalsGuest.style.color = "blue";
		var goalsGuestNo = Math.floor(Math.random()*10)
		goalsGuest.innerText = goalsGuestNo;
		formGameGoalsHost.value = goalsHostNo;
		formGameGoalsGuest.value = goalsGuestNo;
		randomScore.disabled = true;
		finishGame.disabled = false;
	});
	
	var round = 1;
	var goalsHostNo = 0;
	var goalsGuestNo = 0;
	randomPenalty.addEventListener("click", function() {
		
		if (round <= 10) {
			if (round % 2 !== 0) {
				var shooter = document.querySelector("#tableTeamHost tbody tr:nth-child("+Math.ceil(round/2)+") td");
				var isGoal = Math.random() >= 0.5;
				if (isGoal === true) {
					shooter.style.color = "green";
					goalsHostNo++;
					goalsHost.innerText = goalsHostNo;
				} else {
					shooter.style.color = "red";
				}
			} else {
				var shooter = document.querySelector("#tableTeamGuest tbody tr:nth-child("+Math.ceil(round/2)+") td");
				var isGoal = Math.random() >= 0.5;
				if (isGoal === true) {
					shooter.style.color = "green";
					goalsGuestNo++;
					goalsGuest.innerText = goalsGuestNo;
				} else {
					shooter.style.color = "red";
				}
			}
			round++;
		} else {
			formGameGoalsHost.value = goalsHostNo;
			formGameGoalsGuest.value = goalsGuestNo;
			randomPenalty.disabled = true;
			finishGame.disabled = false;	
		}
	});
	
	calculatePenalty.addEventListener("click", function() {
		if (round <= 10) {
			
			var div = document.createElement("div");
			var divHost = comment.firstElementChild;
			var divGuest = comment.lastElementChild;
			
			if (round % 2 !== 0) {
				
				var shooter = document.querySelector("#tableTeamHost tbody tr:nth-child("+Math.ceil(round/2)+") td");
				var shooterSH = parseInt(document.querySelector("#tableTeamHost tbody tr:nth-child("+Math.ceil(round/2)+") td:nth-child(5)").innerHTML);
				shooterSH = shooterSH + (1000 - shooterSH)*Math.random()+0.01;
				
				var goalkeeper = document.querySelector("#tableTeamGuest tbody tr:nth-child("+Math.ceil(round/2)+") td");
				var goalkeeperGK = parseInt(document.querySelector("#tableTeamGuest tbody tr:nth-child("+Math.ceil(round/2)+") td:nth-child(3)").innerHTML);
				goalkeeperGK = goalkeeperGK + (1000 - goalkeeperGK)*Math.random()+0.01;
								
				var isGoal = shooterSH >= goalkeeperGK;
				if (isGoal === true) {
					shooter.style.color = "green";
					goalsHostNo++;
					goalsHost.innerText = goalsHostNo;
					setTimeout(function() {
						comment.style.background = "green";
						divHost.innerText = "GOOAAAL!";
					}, 0);
					setTimeout(function() {
						comment.style.background = "white";
						divHost.innerText = "..";
					}, 1000);
					
				} else {
					shooter.style.color = "red";
					setTimeout(function() {
						comment.style.background = "red";
						divHost.innerText = "MISSED!";
					}, 0);
					setTimeout(function() {
						comment.style.background = "white";
						divHost.innerText = "..";
					}, 1000);
				}
				
//				penaltyWindow(shooter, shooterSH, goalkeeper, goalkeeperGK);
				
			} else {
				var shooter = document.querySelector("#tableTeamGuest tbody tr:nth-child("+Math.ceil(round/2)+") td");
				var shooterSH = parseInt(document.querySelector("#tableTeamGuest tbody tr:nth-child("+Math.ceil(round/2)+") td:nth-child(5)").innerHTML);
				shooterSH = shooterSH + (1000 - shooterSH)*Math.random()+0.01;
				
				var goalkeeper = document.querySelector("#tableTeamHost tbody tr:nth-child("+Math.ceil(round/2)+") td");
				var goalkeeperGK = parseInt(document.querySelector("#tableTeamHost tbody tr:nth-child("+Math.ceil(round/2)+") td:nth-child(3)").innerHTML);
				goalkeeperGK = goalkeeperGK + (1000 - goalkeeperGK)*Math.random()+0.01;
				
				var isGoal = shooterSH >= goalkeeperGK;
				if (isGoal === true) {
					shooter.style.color = "green";
					goalsGuestNo++;
					goalsGuest.innerText = goalsGuestNo;
					setTimeout(function() {
						comment.style.background = "green";
						divGuest.innerText = "GOOAAAL!";
					}, 0);
					setTimeout(function() {
						comment.style.background = "white";
						divGuest.innerText = "..";
					}, 1000);
				} else {
					shooter.style.color = "red";
					setTimeout(function() {
						comment.style.background = "red";
						divGuest.innerText = "MISSED!";
					}, 0);
					setTimeout(function() {
						comment.style.background = "white";
						divGuest.innerText = "..";
					}, 1000);
				}

//				penaltyWindow(shooter, shooterSH, goalkeeper, goalkeeperGK);

			}
			round++;
		} else {
			formGameGoalsHost.value = goalsHostNo;
			formGameGoalsGuest.value = goalsGuestNo;
			randomPenalty.disabled = true;
			finishGame.disabled = false;	
		}
	});
	
	function penaltyWindow(shooter, shooterSH, goalkeeper, goalkeeperGK) {
		alert(	
				"Shooter: "+shooter+"\n"+
				"SH: "+shooterSH.toFixed()+"\n\n"+
				"Goalkeeper: "+goalkeeper+"\n"+
				"GK: "+goalkeeperGK.toFixed()
		)
	}
	
});