package com.kyle.galactic_conquest.maps;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.imageio.ImageIO;

public class GameOfThrones {
	
	private Hashtable<ArrayList<String>,ArrayList<int[]>> _territories = new Hashtable<ArrayList<String>, ArrayList<int[]>>();
	private Hashtable<String,Color> _region_colors = new Hashtable<String, Color>();
	private Hashtable<String,BufferedImage> _region_sigil = new Hashtable<String,BufferedImage>();
	
	public GameOfThrones() {
		
		// GENERATE REGIONAL COLORS
		
		// The North
		_region_colors.put("The North", new Color(255,255,255));
		try {
			BufferedImage img = ImageIO.read(new File("Images/House_Stark.jpg"));
			img = this.resize(img, 35, 35);
		    _region_sigil.put("The North", img);
		} catch (IOException e) {
			System.out.println("exception caught the North");
		}
		
		// The Boltons
		
		_region_colors.put("The Boltons", new Color(94,33,30));
		try {
			BufferedImage img = ImageIO.read(new File("Images/House_Bolton.jpg"));
			img = this.resize(img, 35, 35);
		    _region_sigil.put("The Boltons", img);
		} catch (IOException e) {
		}
		
		// The Iron Islands
		_region_colors.put("The Iron Islands", new Color(0,0,0));
		try {
			BufferedImage img = ImageIO.read(new File("Images/House_Greyjoy.jpg"));
			img = this.resize(img, 35, 35);
		    _region_sigil.put("The Iron Islands", img);
		} catch (IOException e) {
			System.out.println("exception caught the II");
		}
		
		// The Riverlands
		_region_colors.put("The Riverlands", new Color(8, 50, 136));
		try {
			BufferedImage img = ImageIO.read(new File("Images/House_Tully.jpg"));
			img = this.resize(img, 35, 35);
		    _region_sigil.put("The Riverlands", img);
		} catch (IOException e) {
		}
		
		// The Vale
		_region_colors.put("The Vale", new Color(82, 128, 214));
		try {
			BufferedImage img = ImageIO.read(new File("Images/House_Arryn.jpg"));
			img = this.resize(img, 35, 35);
		    _region_sigil.put("The Vale", img);
		} catch (IOException e) {
		}
		
		// The Westerlands
		_region_colors.put("The Westerlands", new Color(139, 8, 0));
		try {
			BufferedImage img = ImageIO.read(new File("Images/House_Lannister.jpg"));
			img = this.resize(img, 35, 35);
		    _region_sigil.put("The Westerlands", img);
		} catch (IOException e) {
		}
		
		// The Reach
		_region_colors.put("The Reach", new Color(76, 134, 13));
		try {
			BufferedImage img = ImageIO.read(new File("Images/House_Tyrell.jpg"));
			img = this.resize(img, 35, 35);
		    _region_sigil.put("The Reach", img);
		} catch (IOException e) {
		}
		
		// The Crownlands
		//_region_colors.put("The Crownlands", new Color(23, 7, 4));
		_region_colors.put("The Crownlands", new Color(0,0,0));
		try {
			BufferedImage img = ImageIO.read(new File("Images/House_Targaryen.jpg"));
			img = this.resize(img, 35, 35);
		    _region_sigil.put("The Crownlands", img);
		} catch (IOException e) {
		}
		
		// The Stormlands
		_region_colors.put("The Stormlands", new Color(227, 198, 6));
		try {
			BufferedImage img = ImageIO.read(new File("Images/House_Baratheon.jpg"));
			img = this.resize(img, 35, 35);
		    _region_sigil.put("The Stormlands", img);
		} catch (IOException e) {
		}
		
		// Dorne
		_region_colors.put("Dorne", new Color(221, 138, 8));
		try {
			BufferedImage img = ImageIO.read(new File("Images/House_Martell.jpg"));
			img = this.resize(img, 35, 35);
		    _region_sigil.put("Dorne", img);
		} catch (IOException e) {
		}
		
		
		// GENERATE TERRITORY SHAPES AND ADD TO HASHTABLE
		
		// Winterfell
		int xPoints[] = {334, 347, 363, 395, 404, 425, 451, 496, 521, 530, 532, 537, 536, 533, 534, 541, 544, 504, 461, 417, 400, 396, 396, 389, 387, 380, 378, 374, 372, 371, 364, 361, 360, 257, 350, 332};
        int yPoints[] = {261, 263, 267, 276, 274, 283, 285, 292, 306, 321, 340, 360, 375, 383, 393, 396, 409, 403, 421, 431, 431, 419, 406, 402, 389, 387, 384, 386, 386, 381, 380, 377, 369, 363, 360, 340}; 
        int label[] = {389, 360};
        ArrayList<int[]> coords = new ArrayList<int[]>();
        coords.add(xPoints);
        coords.add(yPoints);
        coords.add(label);
        ArrayList<String> key = new ArrayList<String>();
        key.add("Winterfell");
        key.add("The Iron Islands");
        _territories.put(key,coords);
        
        // The Lonely Hills
        int[] xPoints2 = {521, 496, 451, 425, 436, 441, 444, 457, 464, 466, 461, 466, 479, 492, 499, 511, 
        		543, 566,  569, 562, 561, 561, 564, 559, 562, 567, 573, 572, 557, 558, 565, 570, 574, 576, 
        		575, 582, 584, 578, 576, 580, 577, 569, 564, 553, 534};
        
        int[] yPoints2 = {306, 292, 285, 283, 273, 273, 268, 262, 253, 232, 192, 177, 185, 189, 189, 179, 
        		160, 153,  159, 180, 193, 225, 237, 245, 248, 251, 252, 258, 268, 275, 278, 283, 294, 299, 
        		304, 307, 313, 314, 319, 322, 324, 325, 321, 317, 308};
        
        ArrayList<int[]> coords2 = new ArrayList<int[]>();
        coords2.add(xPoints2);
        coords2.add(yPoints2);
        int label2[] = {482, 240};
        coords2.add(label2);
        ArrayList<String> key2 = new ArrayList<String>();
        key2.add("The Lonely Hills");
        key2.add("The Boltons");
        _territories.put(key2,coords2);
        
        // Widow's Watch
        int[] xPoints3 = {521, 534, 553, 564, 571, 578, 583, 586, 593, 594, 593, 596, 597, 589, 582, 586, 591, 597, 599, 601, 605, 614, 615, 613, 620, 619, 612, 618, 624, 622, 634, 643, 644, 653, 658, 655, 648, 641, 623, 612, 603, 582, 570, 564, 559, 551, 545, 541, 534, 533, 536, 537, 538, 532, 531, 529};
        int[] yPoints3 = {306, 308, 317, 321, 328, 330, 337, 338, 339, 343, 348, 355, 360, 361, 362, 369, 372, 375, 379, 381, 391, 391, 403, 408, 410, 416, 420, 428, 425, 434, 435, 441, 445, 445, 450, 456, 455, 454, 453, 448, 443, 442, 437, 432, 421, 414, 407, 409, 396, 393, 383, 377, 362, 342, 330, 320};
        
        int label3[] = {550, 385};
        ArrayList<int[]> coords3 = new ArrayList<int[]>();
        coords3.add(xPoints3);
        coords3.add(yPoints3);
        coords3.add(label3);
        ArrayList<String> key3 = new ArrayList<String>();
        key3.add("Widow's Watch");
        key3.add("The Boltons");
        _territories.put(key3,coords3);
        
        // White Harbor
        int[] xPoints4 = {545, 551, 559, 564, 566, 565, 561, 558, 559, 554, 555, 551, 550, 551, 543, 532, 528, 522, 511, 507, 505, 499, 487, 483, 473, 465, 463, 462, 463, 463, 461, 454, 453, 452, 451, 450, 447, 446, 440, 440, 439, 436, 435, 439, 441, 440, 443,  440, 432, 421, 409, 398, 384, 372,  373, 373, 369, 367, 379, 384, 393, 399, 417, 443, 459, 471, 480, 489, 498, 511, 526, 537};
        int[] yPoints4 = {407, 414, 421, 432, 442, 452, 456, 467, 487, 490, 497, 503, 506, 510, 518, 524, 526, 524, 530, 529, 523, 520, 521, 526, 532, 533, 531, 527, 517, 512, 510, 513, 511, 506, 499, 493, 487, 478, 474, 472, 468, 467, 472, 478, 484, 490, 493,  501, 497, 492, 490, 488, 489, 494,  488, 479, 469, 462, 448, 438, 433, 431, 430, 428, 421, 420, 415, 410, 406, 403, 402, 405};
        
        int label4[] = {428, 456};
        ArrayList<int[]> coords4 = new ArrayList<int[]>();
        coords4.add(xPoints4);
        coords4.add(yPoints4);
        coords4.add(label4);
        ArrayList<String> key4 = new ArrayList<String>();
        key4.add("White Harbor");
        key4.add("The North");
        _territories.put(key4,coords4);
        
        // The Grey Cliffs
        int[] xPoints5 = {569, 562, 561, 561, 564, 559, 562, 567, 573, 572, 557, 558, 565, 570, 574, 576, 584, 595, 600, 602, 611, 612, 620, 635, 637, 636, 640, 640, 642, 642, 646, 647, 651, 656, 658, 656, 660, 662, 667, 670, 669, 673, 672, 658, 679, 678, 686, 685, 691, 688, 688, 682, 682, 676, 673, 656, 650, 644, 636, 628, 629, 617, 610, 594, 586, 580};
        int[] yPoints5 = {159, 180, 193, 225, 237, 245, 248, 251, 252, 258, 268, 275, 278, 283, 294, 299, 300, 309, 311, 315, 312, 300, 298, 287, 279, 272, 266, 258, 255, 250, 249, 255, 255, 253, 259, 262, 266, 277, 280, 276, 269, 263, 251, 250, 241, 234, 225, 214, 205, 200, 193, 185, 176, 172, 166, 167, 169, 169, 180, 178, 174, 172, 167, 165, 162, 159};
        
        int label5[] = {581, 225};
        ArrayList<int[]> coords5 = new ArrayList<int[]>();
        coords5.add(xPoints5);
        coords5.add(yPoints5);
        coords5.add(label5);
        ArrayList<String> key5 = new ArrayList<String>();
        key5.add("The Grey Cliffs");
        key5.add("The Boltons");
        _territories.put(key5,coords5);
        
        // Long Lake
        int[] xPoints6 = {334, 347, 363, 395, 404, 425, 425, 436, 441, 444, 457, 464, 466, 461, 466, 451, 438, 424, 402, 395, 365, 337, 332, 327, 316, 317, 312, 311, 310, 306, 307, 312, 308, 301, 295, 288, 280, 276, 277, 283, 291, 300, 311, 322, 326, 332};
        int[] yPoints6 = {261, 263, 267, 276, 274, 283, 283, 273, 273, 268, 262, 253, 232, 192, 177, 165, 155, 150, 151, 149, 149, 153, 155, 156, 157, 162, 168, 173, 175, 180, 187, 192, 203, 211, 212, 216, 217, 221, 234, 242, 245, 247, 252, 256, 260, 262};
        
        int label6[] = {355, 211};
        ArrayList<int[]> coords6 = new ArrayList<int[]>();
        coords6.add(xPoints6);
        coords6.add(yPoints6);
        coords6.add(label6);
        ArrayList<String> key6 = new ArrayList<String>();
        key6.add("Long Lake");
        key6.add("The North");
        _territories.put(key6,coords6);
        
        // The Gift
        int[] xPoints7 = {566, 543, 511, 499, 492, 479, 466, 451, 438, 424, 402, 395, 365, 337, 332, 327, 317, 311, 308, 304, 304, 311, 316, 320, 328, 336, 343, 354, 353, 367, 375, 388, 412, 455, 502, 527, 538, 543, 544, 547, 555, 565, 563, 568, 567};
        int[] yPoints7 = {152, 160, 179, 189, 189, 185, 177, 165, 155, 150, 151, 149, 149, 153, 155, 156, 156, 150, 148, 145, 140, 138, 134, 130, 126, 120, 119, 114, 103, 89, 73, 67, 67, 71, 72, 69, 70, 77, 90, 93, 98, 122, 129, 137, 147};
        
        int label7[] = {429, 118};
        ArrayList<int[]> coords7 = new ArrayList<int[]>();
        coords7.add(xPoints7);
        coords7.add(yPoints7);
        coords7.add(label7);
        ArrayList<String> key7 = new ArrayList<String>();
        key7.add("The Gift");
        key7.add("The North");
        _territories.put(key7,coords7);
        
        // Wolfswood
        int[] xPoints8 = {331, 335, 338, 337, 335, 337, 337, 338, 332, 326, 322, 311, 300, 291, 283, 277, 276, 267, 265, 258, 251, 245, 236, 233, 231, 229, 226, 225, 226, 233, 232, 222, 215, 208, 204, 187, 182, 181, 180, 183, 190, 190, 197, 199, 200, 207, 216, 235, 253, 266, 273, 290, 304, 311, 318, 325};
        int[] yPoints8 = {341, 329, 328, 321, 310, 306, 282, 269, 262, 260, 256, 252, 247, 245, 242, 234, 221, 221, 219, 219, 223, 222, 216, 212, 204, 197, 200, 208, 217, 224, 229, 240, 241, 247, 251, 249, 259, 273, 286, 298, 311, 320, 333, 339, 346, 353, 344, 336, 335, 337, 340, 339, 333, 334, 337, 338};
        
        int label8[] = {228, 292};
        ArrayList<int[]> coords8 = new ArrayList<int[]>();
        coords8.add(xPoints8);
        coords8.add(yPoints8);
        coords8.add(label8);
        ArrayList<String> key8 = new ArrayList<String>();
        key8.add("Wolfswood");
        key8.add("The North");
        _territories.put(key8,coords8);
        
        // Torrhen's Square
        int[] xPoints9 = {207, 216, 235, 253, 266, 273, 290, 304, 311, 318, 325, 332, 350, 357, 360, 361, 364, 371, 372, 374, 378, 380, 387, 389, 396, 396, 400, 386, 380, 374,  366, 355, 345, 331, 321, 315, 311, 306, 296, 285, 272, 262, 252, 247, 245, 236, 226,  225, 223, 222, 214, 205, 200,  198, 198, 203, 207};
        int[] yPoints9 = {353, 344, 336, 335, 337, 340, 339, 333, 334, 337, 338, 340, 360, 363, 369, 377, 380, 381, 386, 386, 384, 387, 389, 402, 406, 419, 431, 437, 447, 455,  460, 455, 449, 448, 445, 440, 431, 421, 410, 399, 397, 399, 399, 407, 411, 419, 421,  415, 413, 406, 401, 391, 387,  380, 373, 366, 357};
        
        int label9[] = {206, 383};
        ArrayList<int[]> coords9 = new ArrayList<int[]>();
        coords9.add(xPoints9);
        coords9.add(yPoints9);
        coords9.add(label9);
        ArrayList<String> key9 = new ArrayList<String>();
        key9.add("Torrhen's Square");
        key9.add("The North");
        _territories.put(key9,coords9);
        
        // Sea Dragon Point
        int[] xPoints10 = {200, 198, 198, 203, 207, 207, 200, 199, 197, 190, 190, 183, 180, 181, 182, 187, 186, 182, 183, 175, 168, 163, 155, 150, 145, 142, 134, 131, 123, 119, 119, 123, 139, 148, 148, 147, 146, 138, 137, 133, 126, 123, 123, 138,  140, 147, 159, 159, 165, 165, 162, 158, 157, 147, 143, 149, 148,  156, 166, 173, 183, 192};
        int[] yPoints10 = {387, 380, 373, 366, 357, 353, 346, 339, 333, 320, 311, 298, 286, 273, 259, 249, 240, 235, 228, 225, 223, 216, 213, 209, 202, 201, 208, 211, 213, 217, 221, 225, 226, 237, 256, 262, 267, 270, 276, 281, 283, 286, 292, 298,  308, 317, 341, 346, 352, 362, 367, 369, 375, 377, 383, 390, 393,  393, 396, 393, 392, 388};
        
        int label10[] = {143, 282};
        ArrayList<int[]> coords10 = new ArrayList<int[]>();
        coords10.add(xPoints10);
        coords10.add(yPoints10);
        coords10.add(label10);
        ArrayList<String> key10 = new ArrayList<String>();
        key10.add("Sea Dragon Point");
        key10.add("The Iron Islands");
        _territories.put(key10,coords10);
        
        // Stony Shore
        int[] xPoints11 = {140, 147, 159, 159, 165, 165, 162, 158, 157, 147, 143, 149,  148, 136, 132, 125, 116, 108, 105, 99,  90, 78, 69, 62, 54, 51, 57, 55, 49, 45, 46, 47, 45, 44, 48, 48, 53, 60, 63, 64, 71, 77, 81, 85, 89, 104, 109, 119, 128, 127, 120, 119, 123, 129, 127, 120, 119, 124, 132};
        int[] yPoints11 = {308, 317, 341, 346, 352, 362, 367, 369, 375, 377, 383, 390,  393, 400, 406, 411, 413, 419, 421, 422,  431, 437, 445, 450, 451, 445, 436, 429, 426, 418, 408, 403, 398, 393, 389, 382, 375, 360, 355, 347, 341, 334, 334, 336, 333, 340, 344, 346, 340, 338, 339, 333, 329, 325, 317, 311, 306, 305, 308};
        
        int label11[] = {60, 377};
        ArrayList<int[]> coords11 = new ArrayList<int[]>();
        coords11.add(xPoints11);
        coords11.add(yPoints11);
        coords11.add(label11);
        ArrayList<String> key11 = new ArrayList<String>();
        key11.add("Stony Shore");
        key11.add("The North");
        _territories.put(key11,coords11);
        
        // The Rills
        int[] xPoints12 = {148, 136, 132, 125, 116, 108, 105, 99,   89,  96,  102, 101, 108, 116, 116, 126, 127, 130, 142, 159, 167, 176, 181,  182, 182, 187, 185, 183, 183, 192, 194, 193, 196, 206, 209, 216, 223, 226, 226,  225, 223, 222, 214, 205, 200, 156, 166, 173, 183};
        int[] yPoints12 = {393, 400, 406, 411, 413, 419, 421, 422,  448, 462, 474, 484, 495, 496, 500, 509, 513, 515, 520, 515, 509, 508, 507,  501, 493, 474, 473, 471, 465, 460, 456, 444, 435, 434, 438, 439, 436, 428, 421,  415, 413, 406, 401, 391, 387, 380, 373, 366, 357};
        
        int label12[] = {100, 451};
        ArrayList<int[]> coords12 = new ArrayList<int[]>();
        coords12.add(xPoints12);
        coords12.add(yPoints12);
        coords12.add(label12);
        ArrayList<String> key12 = new ArrayList<String>();
        key12.add("The Rills");
        key12.add("The North");
        _territories.put(key12,coords12);
        
        // The Barrowlands
        int[] xPoints13 = {182, 182, 187, 185, 183, 183, 192, 194, 193, 196, 206, 209, 216, 223, 226, 226, 236, 245, 247, 252, 262, 272, 285, 296, 306, 311, 315, 321, 331, 345, 355,  366, 368, 372, 373,  372, 362, 357, 350, 341, 335, 331, 326, 318, 299,  291, 278, 269, 267, 260, 257, 251, 244, 238, 229, 222, 216, 205, 198, 193, 190, 189, 186};
        int[] yPoints13 = {501, 493, 474, 473, 471, 465, 460, 456, 444, 435, 434, 438, 439, 436, 428, 421, 419, 411, 407, 399, 399, 397, 399, 410, 421, 431, 440, 445, 448, 449, 455,  460, 469, 476, 485,  493, 502, 503, 501, 502, 506, 507, 504, 506, 508,  505, 501, 500, 502, 501, 500, 501, 506, 507, 511, 513, 511, 514, 510, 511, 507, 501, 502};
        
        int label13[] = {205, 471};
        ArrayList<int[]> coords13 = new ArrayList<int[]>();
        coords13.add(xPoints13);
        coords13.add(yPoints13);
        coords13.add(label13);
        ArrayList<String> key13 = new ArrayList<String>();
        key13.add("The Barrowlands");
        key13.add("The North");
        _territories.put(key13,coords13);
        
     	// Bear Island
        				// West
        int[] xPoints14 = {222, 221, 225, 223, 220, 218, 217, 212, 205, 200, 198, 199, 207, 216, 221,
        		// Bay of Ice
        				   233, 241, 243, 246, 243, 241, 238, 234, 230, 226};
        int[] yPoints14 = {175, 171, 166, 162, 160, 165, 174, 178, 177, 170, 166, 156, 152, 145, 142,
        				   148, 152, 159, 165, 169, 174, 177, 176, 179, 178};
        
        int label14[] = {196, 189};
        ArrayList<int[]> coords14 = new ArrayList<int[]>();
        coords14.add(xPoints14);
        coords14.add(yPoints14);
        coords14.add(label14);
        ArrayList<String> key14 = new ArrayList<String>();
        key14.add("Bear Island");
        key14.add("The North");
        _territories.put(key14,coords14);
        
        // The Neck
							// Cape Kraken Border
		int[] xPoints15 = {220, 226, 229, 228, 225, 221, 218,
				   // Blazewater Bay
				   228, 238, 253, 259, 266, 274, 288,
				   // The Barrowlands
				   299, 318, 326, 331, 335, 341, 350, 357, 362, 372,
				   // White Harbor
				   384, 398, 409, 421, 432, 440,
				   // The Three Sisters
					436, 430, 433, 429, 430, 415, 415, 409, 402, 397, 400, 404, 404, 391, 382, 391, 390,
					//West Vale
					385, 381,
					// The Twins
					374, 367, 361, 355, 337, 326, 321, 315, 304, 298, 294, 292, 284, 279, 270, 265, 259,
					// Ironman's Bay North
					249, 243, 240, 233, 230, 227};
		
		int[] yPoints15 = {612, 597, 581, 566, 549, 535, 526,
				   // Blazewater Bay
				   519, 517, 512, 514, 509, 510, 504,
				   // The Barrowlands
				   508, 506, 504, 507, 506, 502, 501, 503, 502, 493,
				   // White Harbor
				   489, 488, 490, 492, 497, 501,
				   // The Three Sisters
				   510, 514, 523, 528, 534, 540, 549, 559, 566, 577, 584, 587, 593, 594, 605, 610, 617,
				   // West Vale
				   619, 622,
				   // The Twins
				   625, 626, 634, 637, 636, 633, 636, 642, 643, 640, 644, 648, 649, 646, 645, 640, 642,
				   // Ironman's Bay North
				    642, 636, 628, 626, 623, 618};
		
		int label15[] = {253, 579};
		ArrayList<int[]> coords15 = new ArrayList<int[]>();
		coords15.add(xPoints15);
		coords15.add(yPoints15);
		coords15.add(label15);
		ArrayList<String> key15 = new ArrayList<String>();
		key15.add("The Neck");
		key15.add("The Iron Islands");
		_territories.put(key15,coords15);
		
		// Cape Kraken
							// The Neck						   Blazewater Bay																																		        // Ironman Bay North
        int[] xPoints16 = {220, 226, 229, 228, 225, 221, 218,  209, 201, 196, 188, 175, 171, 167, 164, 157, 147, 142, 135, 133, 136, 143, 143, 138, 131, 123, 120, 111, 106, 103,  98,  87,  82,  77,  65,  63,  56,  56,   59,  60,  67,  75,  85,  99, 114, 122, 132, 139, 147, 162, 173, 183, 189, 196, 210, 215};
        int[] yPoints16 = {612, 597, 581, 566, 549, 535, 526,  522, 521, 523, 522, 523, 528, 531, 537, 541, 545, 548, 549, 553, 555, 559, 565, 566, 564, 562, 558, 556, 551, 544, 547, 551, 559, 566, 580, 585, 590, 596,  602, 607, 613, 619, 620, 620, 616, 621, 619, 614, 614, 611, 608, 605, 603, 608, 610, 611};
        
        int label16[] = {79, 588};
        ArrayList<int[]> coords16 = new ArrayList<int[]>();
        coords16.add(xPoints16);
        coords16.add(yPoints16);
        coords16.add(label16);
        ArrayList<String> key16 = new ArrayList<String>();
        key16.add("Cape Kraken");
        key16.add("The North");
        _territories.put(key16,coords16);
        
        // The Twins
                           // The Neck																		     // Ironman's Bay North								// Ironman's Bay South										 // Red Fork		  // The Trident			// West Vale
        int[] xPoints17 = {374, 367, 361, 355, 337, 326, 321, 315, 304, 298, 294, 292, 284, 279, 270, 265, 259,  259, 267, 269, 276, 270, 261, 255, 243, 240, 242,  246, 262, 268, 280, 284, 287, 305, 313, 315, 312, 315, 313,  322, 329, 335, 342,  346, 351, 355, 365, 376,  378, 380, 381, 386, 388, 385};
        int[] yPoints17 = {625, 626, 634, 637, 636, 633, 636, 642, 643, 640, 644, 648, 649, 646, 645, 640, 642,  649, 657, 667, 671, 677, 680, 685, 690, 701, 704,  710, 710, 704, 703, 700, 695, 697, 703, 711, 719, 725, 731,  731, 735, 739, 740,  731, 715, 708, 706, 704,  688, 672, 661, 651, 645, 632};
        
        int label17[] = {270, 690};
        ArrayList<int[]> coords17 = new ArrayList<int[]>();
        coords17.add(xPoints17);
        coords17.add(yPoints17);
        coords17.add(label17);
        ArrayList<String> key17 = new ArrayList<String>();
        key17.add("The Twins");
        key17.add("The Riverlands");
        _territories.put(key17,coords17);
        
        
        
        
	}
	
	public Hashtable getTerritories() {
		return this._territories;
	}
	
	public void setTerritories(Hashtable h) {
		this._territories = h;
	}
	
	public Hashtable getRegionalColors() {
		return this._region_colors;
	}
	
	public Hashtable<String,BufferedImage> getSymbols() {
		return this._region_sigil;
	}
	
	public void setSymbols(Hashtable<String,BufferedImage> h) {
		this._region_sigil = h;
	}
	
	private static BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }

}
