import { User } from "./user";

export class Instancelog {
    id:number | undefined;
    location:string | undefined;
    stressor:string | undefined;
    user:User | undefined;
    date:Date | undefined;
    deescalation:string | undefined;

    constructor() {}
}
