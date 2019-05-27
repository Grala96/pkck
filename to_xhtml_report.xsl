<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:output method="xhtml" version="1.0" encoding="utf-8"/>
	<xsl:template match="/root">
		<html
			xmlns="http://www.w3.org/1999/xhtml">
			<head>
				<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous"></link>
				<style type="text/css">
	  h1 {
	  margin: 10px 0;
	  }
	  .nav-link {
	  margin: 0 5px;
	  }
	  </style>
				<title>Personal Database</title>
			</head>
			<body style="max-width:850px; margin:10 auto;">
				<ul class="nav justify-content-center">
					<li class="nav-item">
						<a class="nav-link btn btn-secondary" href="#personal-database">Personal Database</a>
					</li>
					<li class="nav-item">
						<a class="nav-link btn btn-secondary" href="#statistics">Statistics</a>
					</li>
					<li class="nav-item">
						<a class="nav-link btn btn-secondary" href="#card-owners">Card Owners</a>
					</li>
					<li class="nav-item">
						<a class="nav-link btn btn-secondary" href="#age-statistics">Age Statistics</a>
					</li>
					<li class="nav-item">
						<a class="nav-link btn btn-secondary" href="#administrators">Administrators</a>
					</li>
				</ul>
				<h1 class="alert alert-dark text-center" id="personal-database">Personal Database</h1>
				<div class="table-responsive">
					<table class="text-center table table-striped table-sm">
						<thead class="thead-light">
							<tr>
								<th scope="col">Name</th>
								<th scope="col">Birthday</th>
								<th scope="col">Country</th>
								<th scope="col">City</th>
								<th scope="col">Company</th>
							</tr>
						</thead>
						<xsl:for-each select="personal-data/person">
							<tr>
								<td>
									<xsl:value-of select="name" />
								</td>
								<td>
									<xsl:value-of select="birthday" />
								</td>
								<td>
									<xsl:value-of select="country" />
								</td>
								<td>
									<xsl:value-of select="city" />
								</td>
								<td>
									<xsl:value-of select="work/company" />
								</td>
							</tr>
						</xsl:for-each>
					</table>
				</div>
				<h1 class="alert alert-dark text-center" id="statistics">Statistics</h1>
				<div class="table-responsive">
					<table class="text-center table table-striped table-sm">
						<thead class="thead-light">
							<tr>
								<th scope="col">Name</th>
								<th scope="col">BMI</th>
								<th scope="col">Weight Rate</th>
							</tr>
						</thead>
						<xsl:for-each select="statistics/bmi-stats/person-bmi">
							<tr>
								<td>
									<xsl:value-of select="name" />
								</td>
								<td>
									<xsl:value-of select="bmi/text()" />
								</td>
								<td>
									<xsl:value-of select="translate(bmi/weight-rate/text(), ' ','')" />
								</td>
							</tr>
						</xsl:for-each>
					</table>
				</div>
				<h1 class="alert alert-dark text-center" id="card-owners">Card Owners</h1>
				<div class="table-responsive" style="max-width: 400px;">
					<table class="text-center table table-striped table-sm">
						<thead class="thead-light">
							<tr>
								<th scope="col">Card</th>
								<th scope="col">Quantity</th>
							</tr>
						</thead>
						<xsl:for-each select="statistics/card-owners/*">
							<tr>
								<td>
									<xsl:value-of select="local-name()"/>
								</td>
								<td>
									<xsl:value-of select="."/>
								</td>
							</tr>
						</xsl:for-each>
					</table>
				</div>
				<h1 class="alert alert-dark text-center" id="age-statistics">Age Statistics</h1>
				<div class="table-responsive" style="max-width: 400px;">
					<table class="text-center table table-striped table-sm">
						<thead class="thead-light">
							<tr>
								<th scope="col">Name</th>
								<th scope="col">Quantity</th>
							</tr>
						</thead>
						<xsl:for-each select="statistics/age-stats/*">
							<tr>
								<td>
									<xsl:value-of select="local-name()"/>
								</td>
								<td>
									<xsl:value-of select="."/>
								</td>
							</tr>
						</xsl:for-each>
					</table>
				</div>
				<h1 class="alert alert-dark text-center" id="administrators">Administrators</h1>
				<div class="table-responsive" style="max-width: 400px;">
					<table class="text-center table table-striped table-sm">
						<thead class="thead-light">
							<tr>
								<th scope="col">Name</th>
								<th scope="col">Index</th>
							</tr>
						</thead>
						<xsl:for-each select="administrators/*[name()!='copyright']">
							<tr>
								<td>
									<xsl:value-of select="substring(text(),2,(string-length(text())-2))" />
								</td>
								<td>
									<xsl:value-of select="index" />
								</td>
							</tr>
						</xsl:for-each>
					</table>
				</div>
				<div class="alert alert-secondary">
					<div class="footer-copyright text-center py-3">
						<xsl:value-of select="/root/administrators/copyright" />
					</div>
				</div>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>