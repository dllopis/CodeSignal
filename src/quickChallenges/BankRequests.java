package quickChallenges;


/* Dennis LLopis
 * Codefights -- Quick Challenge -bankRequests-
 * 
 * You've been asked to program a bot for a popular bank that will automate the management of incoming requests. 
 * There are three types of requests the bank can receive:
 * 
 * 1. transfer i j sum: request to transfer sum amount of money from the ith account to the jth one;
 * 2. deposit i sum: request to deposit sum amount of money in the ith account;
 * 3. withdraw i sum: request to withdraw sum amount of money from the ith account.
 * 4. Your bot should also be able to process invalid requests. 
 * There are two types of invalid requests:
				invalid account number in the requests;
				deposit / withdrawal of a larger amount of money than is currently available.
 * 
 * For the given list of accounts and requests, return the state of accounts after all requests have been processed, 
 * or an array of a single element [-<request_id>] (please note the minus sign), 
 * where <request_id> is the 1-based index of the first invalid request.
 */

public class BankRequests {
	
	static int[] bankRequests(int[] accounts, String[] requests) {

		for(int i = 0;i<requests.length;i++)
		{
			// account selected
			int account;
			// second account in case of a transfer request
			int account2;
			
			// set these amounts after parsing string requests
			int withdrawAmount;
			int depositAmount;
			int transferAmount;
			
			// set string request to be parsed
			String request = requests[i].toLowerCase();
			
			// parse the string
			String[] parsedRequest = request.split(" ");
			
			// set request action
			request = parsedRequest[0];
			
			// based on parsed request, switch will take care of which action to perform
			switch(request)
			{
				case "withdraw":	
					
					account = Integer.parseInt(parsedRequest[1]);
									
					if(account > accounts.length)
					{
						int[] a = new int[1];
						a[0] = -(i+1);
						System.out.println("Invalid Request: " + a[0]);
						return a;
					}
									
					withdrawAmount = Integer.parseInt(parsedRequest[2]);
					
					if(accounts[account-1] < withdrawAmount)
					{
						int[] a = new int[1];
						a[0] = -(i+1);
						System.out.println("Invalid Request: " + a[0]);
						return a;
					}
					withdrawFunds(accounts,account,withdrawAmount);
					break;
								
				case "deposit" : 	
					
					account = Integer.parseInt(parsedRequest[1]);
				
					if(account > accounts.length)
					{
						int[] a = new int[1];
						a[0] = -(i+1);
						System.out.println("Invalid Request: " + a[0]);
						return a;
					}
					
					depositAmount = Integer.parseInt(parsedRequest[2]);
					depositFunds(accounts,account,depositAmount);
					
					break;
								
				case "transfer":	
					
					if(accounts.length <= 1)
					{
						int[] a = new int[1];
						a[0] = -(i+1);
						System.out.println("Invalid Request: " + a[0]);
						return a;
					}
					
					account = Integer.parseInt(parsedRequest[1]);
					account2 = Integer.parseInt(parsedRequest[2]);
					transferAmount = Integer.parseInt(parsedRequest[3]);
					
					if(accounts[account-1] < transferAmount||account > accounts.length || account2 > accounts.length)
					{
						int[] a = new int[1];
						a[0] = -(i+1);
						System.out.println("Invalid Request: " + a[0]);
						return a;
					}
					transferFunds(accounts,account,account2,transferAmount);
					break; 
			
									default:	break;// invalid
			}
		}
			return accounts;
		}
	
	// helper methods
	private static void withdrawFunds(int[] accounts, int account, int withdrawAmount)
	{
		// if account has greater or equal funds, then proceed with withdrawal
		if(accounts[account - 1] >= withdrawAmount)
			accounts[account - 1] -= withdrawAmount;
	}
	private static void depositFunds(int[] accounts, int account, int depositAmount)
	{
		accounts[account-1] += depositAmount;
	}
	private static void transferFunds(int[] accounts, int ithAcc, int jthAcc, int transferAmount)
	{
		if(ithAcc == jthAcc)
			return;
		
		accounts[jthAcc-1] += transferAmount;
		accounts[ithAcc-1] -= transferAmount;
	}
	public static void displayAccounts(int[] accounts)
	{
		System.out.print("Accounts: [ ");
		
		for(int i = 0; i < accounts.length;i++)
		{
			if(i == accounts.length - 1)
				System.out.print(accounts[i] + "]");
			else
				System.out.print(accounts[i] + ", ");
		}
		
		System.out.println("");
	}
	public static void displayRequests(String[] requests)
	{
		System.out.println("Requests: ");
		
		for(int i = 0; i < requests.length;i++)
		{
				System.out.println("\t" + requests[i]);
		}
		System.out.println("");
	}
	public static void main(String[] args) {
		
		// Testcases
		int[] accounts1 	= {10, 100, 20, 50, 30};
		int[] accounts2 	= {20, 1000, 500, 40, 90};
		int[] accounts3		= {92791, 83126, 7932, 33180, 44077, 48367, 34906, 84237, 41703, 28680, 78285, 1443, 64897, 40212, 62784, 75685, 49497, 76826, 59966, 64477};
				
		String[] requests1 	= 	{"withdraw 2 10", "transfer 5 1 20", "deposit 5 20", "transfer 3 4 15"};
		String[] requests2 	= 	{"deposit 3 400", "transfer 1 2 30", "withdraw 4 50"};
		String[] requests3	= 	{
								"transfer 5 16 20570", 
							 	"deposit 15 81053", 
							 	"transfer 18 12 19445", 
								"withdraw 11 21658", 
								"deposit 20 45535", 
							 	"withdraw 13 63316", 
							 	"withdraw 11 66486", 
							 	"withdraw 4 33290", 
							 	"deposit 15 20647", 
							 	"transfer 4 8 44200", 
							 	"withdraw 16 52943", 
							 	"deposit 14 88175", 
							 	"deposit 13 40427", 
							 	"withdraw 8 82585", 
							 	"deposit 9 62598", 
								"transfer 9 20 96544"
						 		};

	// Test 1
		// Display state before request
		displayAccounts(accounts3);
		displayRequests(requests3);
		
		// Perform requests
		bankRequests(accounts3,requests3);
		
		// Display State after request
		System.out.println("State after requests: ");
		displayAccounts(accounts3);
	
		System.out.println("\t---- Next Testcase ----");

	}

}
