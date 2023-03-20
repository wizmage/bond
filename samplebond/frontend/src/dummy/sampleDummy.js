const dummy = (id) => {
    return {
        id: id,
        name: `name ${id}`,
        description: `description ${id}`,
        regUser: 'admin',
        useYn: 'Y'
    }
};

const dummyList = (params) => {
    //params.id
    //params.pageNo
    const totalRecordCount = 100; // 10 page
    const recordCountPerPage = 10;
    const pageSize = 5;
    const pageNo = params?.id || 1;
    const lastIndex = recordCountPerPage;
    const firstIndex = (pageNo - 1) * recordCountPerPage;
    let index = firstIndex + 1;
    let resultList = [];

    for (;index <= lastIndex; index++) {
        resultList.push(dummy(index));
    }
    
    return {
        paging: {
            totalRecordCount: totalRecordCount,
            recordCountPerPage: recordCountPerPage,
            pageSize: pageSize,
            pageNo: pageNo
        },
        resultList: resultList
    }
};

export default {
    dummy: dummy,
    dummyList: dummyList
}