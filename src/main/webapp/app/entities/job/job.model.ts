export interface IJob {
  id?: number;
  jobTitle?: string | null;
  minSalary?: number | null;
  maxSalary?: number | null;
}

export class Job implements IJob {
  constructor(public id?: number, public jobTitle?: string | null, public minSalary?: number | null, public maxSalary?: number | null) {}
}

export function getJobIdentifier(job: IJob): number | undefined {
  return job.id;
}
