/**
 * 
 */

function maxProfit(inventory, orders) {
	
	
	inventory.sort((a,b) => b-a);
	let order_no = 0;
	let i=0;
	let profit = 0;
	
	while(order_no <= orders) {
		
		let firstEl = inventory[i];
		let secondEl = inventory[i+1];
		
		let diff = firstEl-secondEl;
		
		let cur_order = diff*(i+1);
		if(order_no + cur_order > orders) {
			let temp = order_no + cur_order - orders;
			profit += (firstEl*(firstEl+1) - (secondEl+temp)*(secondEl+1+temp))/2 * (i+1);
		} else {
			profit += (firstEl*(firstEl+1) - secondEl*(secondEl+1))/2 * (i+1);
		}
		i++;
		order_no += cur_order;
		
	}
	
}

maxProfit();