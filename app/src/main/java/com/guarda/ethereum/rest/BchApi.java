package com.guarda.ethereum.rest;


import com.guarda.ethereum.models.items.BalanceAndTxResponse;
import com.guarda.ethereum.models.items.BlockHeightResponse;
import com.guarda.ethereum.models.items.BtgBalanceResponse;
import com.guarda.ethereum.models.items.BtgTxListResponse;
import com.guarda.ethereum.models.items.UTXOItem;
import com.guarda.ethereum.models.items.UTXOListResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

interface BchApi {
    @GET("addr/{address}")
    Call<BtgBalanceResponse> getBalance(@Path("address") String address);

    @GET("addrs/{address}/utxo")
    Call<List<UTXOItem>> getUTXOByAddress(@Path("address") String address);

    @GET("/api/blocks/?format=json")
    Call<BlockHeightResponse> getCurrentBlockHeight();

    @GET("txs")
    Call<BtgTxListResponse> getTransactions(@Query("address") String address);
}
