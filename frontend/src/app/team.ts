import { User } from "./user";

export class Team {
    id:number | undefined;
    name:string | undefined;
    users:Array<User> | undefined;

    constructor() {}
}
