export class TicketBean {

    id: number;
	cost: number;
	submitted: string;
	resolved: string;
	description: string;
	author: number;
	resolver: number;
	status: number;
    type: number;
    
    constructor(id: number, cost: number, submitted: string, resolved: string,
        description: string, author: number, resolver: number, status: number, type: number){
            this.id = id;
            this.cost = cost;
            this.submitted = submitted;
            this.resolved = resolved;
            this.description = description;
            this.author = author;
            this.resolver = resolver;
            this.status = status;
            this.type = type;
    }

}
