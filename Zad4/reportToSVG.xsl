<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:svg="http://www.w3.org/2000/svg" xmlns="http://www.w3.org/2000/svg"
    xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:date="http://exslt.org/dates-and-times">
    <xsl:output method="xml" media-type="image/svg" encoding="utf-8"
        doctype-public="-//W3C//DTD SVG 1.1//EN"
        doctype-system="http://www.w3.org/TR/2001/REC-SVG-20010904/DTD/svg10.dtd"/>

    <xsl:template match="/">


        <svg:svg font-family="Calibri" overflow="auto">
            <svg:title> Statystyki GUS </svg:title>
            <svg:g id="main" transform="translate(10,40)">
                <svg:text font-size="35"> Statystyki przeprowadzone przez GUS </svg:text>
                <svg:text y="20"> Przeprowadzone dnia: 
                    <xsl:variable name="full_date" select="date:date()"/>
                    <xsl:value-of select="substring-before($full_date, 'Z')"/>
                </svg:text>
            </svg:g>
                        
            <script type="text/javascript"> 
                <![CDATA[
                    function onMouseOverBar(obj) {
                    	var bar=obj.childNodes[0];
                        bar.setAttribute("fill-opacity","1");
                        var text=obj.childNodes[1];
                        text.setAttribute("visibility","visible");
                    }]]>
            </script>
            
            <script type="text/javascript">
                <![CDATA[
                    function onMouseOutBar(obj) {
                   		var bar=obj.childNodes[0];
                      	bar.setAttribute("fill-opacity","0.7");
                      	var text=obj.childNodes[1];
                        text.setAttribute("visibility","hidden");
                    }]]>
            </script>
            
            <svg:text x="110" y="100" font-size="24">Ilość posiadaczy kart:</svg:text>
            <svg:g transform="translate(100,115)" >
                <xsl:apply-templates select="/root/statistics/card-owners"/>
            </svg:g>
            <svg:text x="110" y="600" font-size="24">Statystyki BMI:</svg:text>
            <svg:g transform="translate(100,600)" >
                <xsl:apply-templates select="/root/statistics/bmi-stats"/>
            </svg:g>
            
            <svg:g transform="translate(900)">
                <a xlink:href="htmlReport.html" target="_blank">
                    <svg:rect x="0" y="0" width="150" height="25" fill="yellowgreen" stroke="black" class="btn" cursor="pointer" />
                    <svg:text x="15" y="18" fill="white" font-size="16">Przejdz do XHTML</svg:text>
                </a>
            </svg:g>
        </svg:svg>
        
        
    </xsl:template>
    

    
    <xsl:template match="/root/statistics/card-owners">
        <svg:rect x="0" y="0" width="900" height="400" fill="#342F69" stroke="black"/>
        <svg:rect x="150" y="10" width="600" height="220" fill="yellowgreen" stroke="white" stroke-width="1"/>
        <svg:g transform="translate(75,15)" font-size="20" fill="white">
            <svg:text x="0" y="10">10</svg:text>
            <svg:text x="0" y="30">9</svg:text>
            <svg:text x="0" y="50">8</svg:text>
            <svg:text x="0" y="70">7</svg:text>
            <svg:text x="0" y="90">6</svg:text>
            <svg:text x="0" y="110">5</svg:text>
            <svg:text x="0" y="130">4</svg:text>
            <svg:text x="0" y="150">3</svg:text>
            <svg:text x="0" y="170">2</svg:text>
            <svg:text x="0" y="190">1</svg:text>
            <svg:text x="0" y="210">0</svg:text>
        </svg:g>
        <xsl:variable name="miejsce_nazwa" select="600 div count(*)"/>
        <xsl:variable name="szerokosc_slupka" select="$miejsce_nazwa div 2"/>
        <svg:g transform="translate(150, 0)" >
            <xsl:for-each select="child::*">
                <xsl:element name="svg:text">
                    <xsl:variable name="x" select="$miejsce_nazwa * (position()-1) + $szerokosc_slupka"/>
                    <xsl:variable name="y" select="310"/>
                    <xsl:attribute name="text-anchor">
                        <xsl:value-of select="'middle'"/>
                    </xsl:attribute>
                    <xsl:attribute name="fill">
                        <xsl:value-of select="'white'"/>
                    </xsl:attribute>
                    <xsl:attribute name="x">
                        <xsl:value-of select="$x"/>
                    </xsl:attribute>
                    <xsl:attribute name="y">
                        <xsl:value-of select="$y"/>
                    </xsl:attribute>
                    <xsl:attribute name="transform">
                        <xsl:value-of select="'rotate(90,'"/>
                        <xsl:value-of select="$x"/>
                        <xsl:value-of select="','"/>
                        <xsl:value-of select="$y"/>
                        <xsl:value-of select="')'"/>
                    </xsl:attribute>
                    <xsl:value-of select="name()"/>
                </xsl:element>
                <svg:g onmouseover="onMouseOverBar(this)" onmouseout="onMouseOutBar(this)">
                    <xsl:element name="svg:rect">
                        
                        <xsl:attribute name="x">
                            <xsl:value-of select="$miejsce_nazwa*(position()-1)"/>
                        </xsl:attribute>
                        <xsl:attribute name="width">
                            <xsl:value-of select="$miejsce_nazwa"/>
                        </xsl:attribute>
                        <xsl:attribute name="style">
                            <xsl:value-of select="'fill: whitesmoke; stroke:black;'"/>
                        </xsl:attribute>
                        <xsl:attribute name="fill-opacity">
                            <xsl:value-of select="'0.7'"/>
                        </xsl:attribute>
                        <xsl:element name="svg:animate">
                            <xsl:attribute name="attributeName">
                                <xsl:value-of select="'y'"/>
                            </xsl:attribute>
                            <xsl:attribute name="from">
                                <xsl:value-of select="'230'"/>
                            </xsl:attribute>
                            <xsl:attribute name="to">
                                <xsl:value-of select="210-(20*current())"/>
                            </xsl:attribute>
                            <xsl:attribute name="dur">
                                <xsl:value-of select="'1s'"/>
                            </xsl:attribute>
                            <xsl:attribute name="fill">
                                <xsl:value-of select="'freeze'"/>
                            </xsl:attribute>
                        </xsl:element>
                        <xsl:element name="svg:animate">
                            <xsl:attribute name="attributeName">
                                <xsl:value-of select="'height'"/>
                            </xsl:attribute>
                            <xsl:attribute name="from">
                                <xsl:value-of select="'0'"/>
                            </xsl:attribute>
                            <xsl:attribute name="to">
                                <xsl:value-of select="20*current()+20"/>
                            </xsl:attribute>
                            <xsl:attribute name="dur">
                                <xsl:value-of select="'1s'"/>
                            </xsl:attribute>
                            <xsl:attribute name="fill">
                                <xsl:value-of select="'freeze'"/>
                            </xsl:attribute>
                        </xsl:element>
                    </xsl:element>
                    <xsl:element name="svg:text">
                        <xsl:attribute name="text-anchor">
                            <xsl:value-of select="'middle'"/>
                        </xsl:attribute>
                        <xsl:attribute name="x">
                            <xsl:value-of select="$miejsce_nazwa*(position()-1)+ $szerokosc_slupka"/>
                        </xsl:attribute>
                        <xsl:attribute name="y">
                            <xsl:value-of select="230"/>
                        </xsl:attribute>
                        <xsl:attribute name="visibility">
                            <xsl:value-of select="'hidden'"/>
                        </xsl:attribute>
                        
                        <xsl:attribute name="style">
                            <xsl:value-of select="'fill:black; font-size: 26;'"/>
                        </xsl:attribute>
                        <xsl:value-of select="node()"/>
                    </xsl:element>
                </svg:g>
            </xsl:for-each>
        </svg:g>	
    </xsl:template>

    <xsl:template match="/root/statistics/bmi-stats">
        <xsl:for-each select="child::*">
            <xsl:variable name="y" select=" 50 * position()"/>
            <xsl:element name="svg:g">
                <xsl:attribute name="transform">
                    <xsl:value-of select="'translate(100,'"/>
                    <xsl:value-of select="$y"/>
                    <xsl:value-of select="')'"/>
                </xsl:attribute>
                <xsl:element name="svg:rect">
                    <xsl:attribute name="width">
                        <xsl:value-of select="bmi/text()"/>
                    </xsl:attribute>
                    <xsl:attribute name="height">
                        <xsl:value-of select="20"/>
                    </xsl:attribute>
                    <xsl:attribute name="fill"><xsl:value-of select="'#342F69'"/></xsl:attribute>
                    <xsl:attribute name="stroke"><xsl:value-of select="'black'"/></xsl:attribute>
                </xsl:element>
                <xsl:element name="svg:text">
                    <xsl:attribute name="transform">
                        <xsl:value-of select="'translate(0,40)'"/>
                    </xsl:attribute>
                    <xsl:value-of select="name"/>
                </xsl:element>
            </xsl:element>
        </xsl:for-each>
    </xsl:template>
        
</xsl:stylesheet>
