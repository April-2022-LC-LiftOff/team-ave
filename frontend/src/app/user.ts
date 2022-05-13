import { Instancelog } from "./instancelog";
import { Team } from "./team";

export class User {
    id:number | undefined;
    email:string | undefined;
    username:string | undefined;
    password:string | undefined;

    team:Team | undefined;
    instancelog:Instancelog | undefined;

    constructor() {}
}
