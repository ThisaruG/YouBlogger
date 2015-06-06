function hidePosts () {
	document.getElementById("other_posts").style.visibility="hidden";
	document.getElementById("other_posts").style.height = "1px";
}

function showPosts() {
	if (document.getElementById("other_posts").style.visibility == "visible") {
		document.getElementById("other_posts").style.visibility = "hidden";
		document.getElementById("other_posts").style.height = "1px";
		document.getElementById("see_more").innerHTML ="<a href = '#'>Show More...</a>";
	}
	else {
		document.getElementById("other_posts").style.visibility = "visible";
		document.getElementById("see_more").innerHTML ="<a href = '#'>Show Less...</a>";
	}
}